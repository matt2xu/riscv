/**
 * Title      : Generated from com.synflow.risc.mem_stage.MEM_forward by Synflow Studio
 * Project    : RISCV
 *
 * File       : MEM_forward.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module MEM_forward(input clock, input reset_n, input [8 : 0] flags_i, input [4 : 0] rd_i, input [31 : 0] value_i, output reg [8 : 0] flags_o, output reg [4 : 0] rd_o, output reg [31 : 0] value_o);


  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Task MEM_forward_0 (line 16)
  task MEM_forward_0(input [8 : 0] flags_i_in, input [4 : 0] rd_i_in, input [31 : 0] value_i_in);
    reg [8 : 0] local_flags_i;
    reg [4 : 0] local_rd_i;
    reg [31 : 0] local_value_i;
    reg [8 : 0] flags_o_out;
    reg [4 : 0] rd_o_out;
    reg [31 : 0] value_o_out;
  begin
    local_flags_i = flags_i_in;
    flags_o_out = local_flags_i;
    local_rd_i = rd_i_in;
    rd_o_out = local_rd_i;
    local_value_i = value_i_in;
    value_o_out = local_value_i;
    flags_o <= flags_o_out;
    rd_o <= rd_o_out;
    value_o <= value_o_out;
  end
  endtask
  

  /**
   * Synchronous process
   */
  always @(negedge reset_n or posedge clock) begin // body of MEM_forward
    if (~reset_n) begin
      flags_o <= 0;
      rd_o <= 0;
      value_o <= 0;
    end else begin
      //
      if (1) begin
        // Body of MEM_forward_0 (line 16)
        MEM_forward_0(flags_i, rd_i, value_i);
      end
    end
  end

endmodule //MEM_forward
