/*
 * Copyright (c) 2012-2013, Synflow SAS
 * All rights reserved.
 * 
 * REDISTRIBUTION of this file in source and binary forms, with or without
 * modification, is NOT permitted in any way.
 *
 * The use of this file in source and binary forms, with or without
 * modification, is permitted if you have a valid commercial license of
 * Synflow Studio.
 * If you do NOT have a valid license of Synflow Studio: you are NOT allowed
 * to use this file.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE
 */

/**
 * Title   : Asynchronous FIFO
 * Authors : Nicolas Siret <nicolas.siret@synflow.com>, Matthieu Wipliez <matthieu.wipliez@synflow.com>
 */
module Asynchronous_fifo
  #(parameter depth = 8, width = 16)
  (
    input din_clock, input dout_clock,
    input reset_n,
    input [width - 1 : 0] din, input din_send,
    input ready,
    output [width - 1 : 0] dout, output reg dout_send,
    output full,
    output empty,
    output almost_full
  );

  /*
   * Wires
   */
  wire        full_i;
  wire        empty_i;
  wire        wr_enable;
  wire        rd_enable;
  wire [depth - 1 : 0] rd_address;
  wire [depth - 1 : 0] wr_address;
  wire [depth - 1 : 0] rd_address_din;
  wire [depth - 1 : 0] wr_address_dout;

  /**
   * assignments
   */
  assign full = full_i;
  assign empty = empty_i;

  always @(negedge reset_n or posedge dout_clock)
    if (~reset_n)
      dout_send <= 0;
    else
      dout_send <= rd_enable;

  // wr_enable and rd_enable are active iff the flags allow it
  assign wr_enable = din_send & !full_i;
  assign rd_enable = ready && !empty_i;

  Dual_Port_RAM #(.depth(depth), .width(width)) ram
  (
    .wr_clock(din_clock),
    .rd_clock(dout_clock),
    .reset_n(reset_n),
    .wr_address(wr_address),
    .data(din),
    .data_send(wr_enable),
    .rd_address(rd_address),
    .q(dout)
  );

  FIFO_Write_Controller #(.depth(depth)) wr_ctrl
  (
    .reset_n(reset_n),
    .wr_clock(din_clock),
    .enable(wr_enable),
    .rd_address(rd_address_din),
    .full(full_i),
    .wr_address(wr_address),
    .almost_full(almost_full)
  );

  Simple_Register #(.depth(depth)) sync_rd_address_din
  (
    .reset_n(reset_n),
    .clock(din_clock),
    .din(rd_address),
    .dout(rd_address_din)
  );

  FIFO_Read_Controller #(.depth(depth)) rd_ctrl
  (
    .reset_n(reset_n),
    .rd_clock(dout_clock),
    .enable(rd_enable),
    .wr_address(wr_address_dout),
    .empty(empty_i),
    .rd_address(rd_address)
  );

  Simple_Register #(.depth(depth)) sync_wr_address_dout
  (
    .reset_n(reset_n),
    .clock(dout_clock),
    .din(wr_address),
    .dout(wr_address_dout)
  );

endmodule
