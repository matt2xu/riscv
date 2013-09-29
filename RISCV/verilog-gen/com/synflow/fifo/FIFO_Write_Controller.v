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
 * Title   : FIFO write controller
 * Authors : Nicolas Siret <nicolas.siret@synflow.com>, Matthieu Wipliez <matthieu.wipliez@synflow.com>
 */
module FIFO_Write_Controller
  #(parameter depth = 8)
  (
    input reset_n,
    input wr_clock,
    input enable,
    input [depth - 1 : 0] rd_address,
    output full,
    output reg almost_full,
    output reg [depth - 1 : 0] wr_address
  );

  /*
   * Registers and wires
   */
  wire [depth - 1 : 0] always_next, almost_wr_address_n, almost_wr_address_p;

  localparam unsigned_depth_p = 3 * (2 ** depth) / 4 + 2;
  localparam unsigned_depth_n = (2 ** depth) / 4 + 2;

  assign always_next = wr_address + 1;
  assign almost_wr_address_p = wr_address +  unsigned_depth_p;
  assign almost_wr_address_n = wr_address + unsigned_depth_n;
  assign full = always_next == rd_address;

  always @(negedge reset_n or posedge wr_clock)
    if (~reset_n) begin
      wr_address  <= 0;
   	  almost_full <= 0;
    end else begin
      wr_address <= wr_address + enable;
      if (almost_wr_address_n == rd_address)
        almost_full <= 1;
      else if (almost_wr_address_p == rd_address)
        almost_full <= 0;
    end

endmodule
