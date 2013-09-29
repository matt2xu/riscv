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

module EX_stage(input clock, input reset_n, input [31 : 0] op1, input [31 : 0] op2, input [31 : 0] rd, output reg [31 : 0] result, output reg [4 : 0] rd_o);


  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Task EX_stage_0 (line 16)
  task EX_stage_0(input [31 : 0] op1_in, input [31 : 0] op2_in, input [31 : 0] rd_in);
    reg [31 : 0] local_op1;
    reg [31 : 0] local_op2;
    reg [31 : 0] local_rd;
    reg [31 : 0] result_out;
    reg [4 : 0] rd_o_out;
  begin
    local_op1 = op1_in;
    local_op2 = op2_in;
    result_out = (local_op1 + local_op2);
    local_rd = rd_in;
    rd_o_out = local_rd;
    result <= result_out;
    rd_o <= rd_o_out;
  end
  endtask
  

  /**
   * Synchronous process
   */
  always @(negedge reset_n or posedge clock) begin // body of EX_stage
    if (~reset_n) begin
      result <= 0;
      rd_o <= 0;
    end else begin
      //
      if (1) begin
        // Body of EX_stage_0 (line 16)
        EX_stage_0(op1, op2, rd);
      end
    end
  end

endmodule //EX_stage
