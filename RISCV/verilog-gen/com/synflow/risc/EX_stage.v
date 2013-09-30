/**
 * Title      : Generated from com.synflow.risc.EX_stage by Synflow Studio
 * Project    : RISCV
 *
 * File       : EX_stage.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module EX_stage(input clock, input reset_n, input [31 : 0] op1, input [31 : 0] op2, input [31 : 0] rd, input [8 : 0] flags, output reg [31 : 0] addr, output reg [31 : 0] value, output reg [4 : 0] rd_o, output reg [8 : 0] flags_o);


  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Task EX_stage_0 (line 16)
  task EX_stage_0(input [31 : 0] op1_in, input [31 : 0] op2_in, input [31 : 0] rd_in, input [8 : 0] flags_in);
    reg [31 : 0] local_op1;
    reg [31 : 0] local_op2;
    reg [31 : 0] local_rd;
    reg [8 : 0] local_flags;
    reg [31 : 0] value_out;
    reg [4 : 0] rd_o_out;
    reg [8 : 0] flags_o_out;
  begin
    local_op1 = op1_in;
    local_op2 = op2_in;
    value_out = (local_op1 + local_op2);
    local_rd = rd_in;
    rd_o_out = local_rd;
    local_flags = flags_in;
    flags_o_out = local_flags;
    value <= value_out;
    rd_o <= rd_o_out;
    flags_o <= flags_o_out;
  end
  endtask
  

  /**
   * Synchronous process
   */
  always @(negedge reset_n or posedge clock) begin // body of EX_stage
    if (~reset_n) begin
      addr <= 0;
      value <= 0;
      rd_o <= 0;
      flags_o <= 0;
    end else begin
      //
      if (1) begin
        // Body of EX_stage_0 (line 16)
        EX_stage_0(op1, op2, rd, flags);
      end
    end
  end

endmodule //EX_stage
