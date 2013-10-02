/**
 * Title      : Generated from com.synflow.risc.test.InstructionTranslator by Synflow Studio
 * Project    : RISCV
 *
 * File       : InstructionTranslator.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module InstructionTranslator(input clock, input reset_n, input [7 : 0] unused);

  `include "com/synflow/risc/RISCV_Definitions.v"

  /**
   * State variables
   */


  /**
   * Functions
   */
  function [31 : 0] lw(input [4 : 0] rd, input [4 : 0] rs1, input signed [11 : 0] imm12);
    reg [6 : 0] local_RISCV_LOAD;
    reg [31 : 0] _expr;
    reg [26 : 0] _expr0;
    reg signed [21 : 0] _expr1;
    reg [8 : 0] _expr2;
    begin
      local_RISCV_LOAD = RISCV_LOAD;
      _expr = (rd << 32'h0000001b);
      _expr0 = (rs1 << 27'h0000016);
      _expr1 = (imm12 << $signed(22'h00000a));
      _expr2 = (9'h002 << 9'h007);
      lw = $unsigned(((($signed((_expr | _expr0)) | _expr1) | _expr2) | local_RISCV_LOAD));
    end
  endfunction
  

  /**
   * FSM
   */
  reg FSM;
  localparam FSM_InstructionTranslator_0 = 1'b0;
  localparam FSM_InstructionTranslator_1 = 1'b1;

  /**
   * Behavior
   */
  // Task InstructionTranslator_0 (line 34)
  task InstructionTranslator_0;
    reg [4 : 0] rd;
    reg [4 : 0] rs1;
    reg signed [11 : 0] imm;
    reg [6 : 0] local_RISCV_OP_IMM;
    reg [4 : 0] rd0;
    reg [4 : 0] rs10;
    reg signed [11 : 0] imm0;
    reg [4 : 0] rd1;
    reg [4 : 0] rs11;
    reg signed [11 : 0] imm1;
    reg [4 : 0] rd2;
    reg [4 : 0] rs12;
    reg signed [11 : 0] imm2;
    reg [4 : 0] rd3;
    reg [4 : 0] rs13;
    reg signed [11 : 0] imm3;
    reg [4 : 0] rd4;
    reg [4 : 0] rs14;
    reg [4 : 0] rs2;
    reg [6 : 0] local_RISCV_OP;
    reg [31 : 0] _expr;
    reg [26 : 0] _expr0;
    reg signed [21 : 0] _expr1;
    reg [31 : 0] _expr2;
    reg [26 : 0] _expr3;
    reg signed [21 : 0] _expr4;
    reg [31 : 0] _expr5;
    reg [26 : 0] _expr6;
    reg signed [21 : 0] _expr7;
    reg [31 : 0] _expr8;
    reg [26 : 0] _expr9;
    reg signed [21 : 0] _expr10;
    reg [31 : 0] _expr11;
    reg [26 : 0] _expr12;
    reg signed [21 : 0] _expr13;
    reg [31 : 0] _expr14;
    reg [26 : 0] _expr15;
    reg [21 : 0] _expr16;
  begin
    local_RISCV_OP_IMM = RISCV_OP_IMM;
    local_RISCV_OP = RISCV_OP;
    rd = 5'h01;
    rs1 = 5'h00;
    imm = $signed(12'h005);
    $display("addi %0h %0h %0h", rd, rs1, imm);
    _expr = (rd << 32'h0000001b);
    _expr0 = (rs1 << 27'h0000016);
    _expr1 = (imm << $signed(22'h00000a));
    $display("%0h", (($signed((_expr | _expr0)) | _expr1) | local_RISCV_OP_IMM));
    rd0 = 5'h02;
    rs10 = 5'h00;
    imm0 = $signed(12'h008);
    $display("addi %0h %0h %0h", rd0, rs10, imm0);
    _expr2 = (rd0 << 32'h0000001b);
    _expr3 = (rs10 << 27'h0000016);
    _expr4 = (imm0 << $signed(22'h00000a));
    $display("%0h", (($signed((_expr2 | _expr3)) | _expr4) | local_RISCV_OP_IMM));
    rd1 = 5'h00;
    rs11 = 5'h00;
    imm1 = $signed(12'h000);
    $display("addi %0h %0h %0h", rd1, rs11, imm1);
    _expr5 = (rd1 << 32'h0000001b);
    _expr6 = (rs11 << 27'h0000016);
    _expr7 = (imm1 << $signed(22'h00000a));
    $display("%0h", (($signed((_expr5 | _expr6)) | _expr7) | local_RISCV_OP_IMM));
    rd2 = 5'h00;
    rs12 = 5'h00;
    imm2 = $signed(12'h000);
    $display("addi %0h %0h %0h", rd2, rs12, imm2);
    _expr8 = (rd2 << 32'h0000001b);
    _expr9 = (rs12 << 27'h0000016);
    _expr10 = (imm2 << $signed(22'h00000a));
    $display("%0h", (($signed((_expr8 | _expr9)) | _expr10) | local_RISCV_OP_IMM));
    rd3 = 5'h00;
    rs13 = 5'h00;
    imm3 = $signed(12'h000);
    $display("addi %0h %0h %0h", rd3, rs13, imm3);
    _expr11 = (rd3 << 32'h0000001b);
    _expr12 = (rs13 << 27'h0000016);
    _expr13 = (imm3 << $signed(22'h00000a));
    $display("%0h", (($signed((_expr11 | _expr12)) | _expr13) | local_RISCV_OP_IMM));
    rd4 = 5'h03;
    rs14 = 5'h01;
    rs2 = 5'h02;
    $display("add %0h %0h %0h", rd4, rs14, rs2);
    _expr14 = (rd4 << 32'h0000001b);
    _expr15 = (rs14 << 27'h0000016);
    _expr16 = (rs2 << 22'h000011);
    $display("%0h", (((_expr14 | _expr15) | _expr16) | local_RISCV_OP));
  end
  endtask
  

  /**
   * Synchronous process
   */
  always @(negedge reset_n or posedge clock) begin // body of InstructionTranslator
    if (~reset_n) begin
      FSM    <= FSM_InstructionTranslator_0;
    end else begin
      //
      case (FSM)
        FSM_InstructionTranslator_0 : begin
          if (1) begin
            // Body of InstructionTranslator_0 (line 34)
            InstructionTranslator_0;
            FSM <= FSM_InstructionTranslator_1;
          end
        end
        
        FSM_InstructionTranslator_1 : begin
        end
      endcase
    end
  end

endmodule //InstructionTranslator
