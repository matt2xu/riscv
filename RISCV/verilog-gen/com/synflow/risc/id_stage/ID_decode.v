/**
 * Title      : Generated from com.synflow.risc.id_stage.ID_decode by Synflow Studio
 * Project    : RISCV
 *
 * File       : ID_decode.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module ID_decode(input clock, input reset_n, input [31 : 0] instr, output reg [4 : 0] rd, output reg [8 : 0] flags, output reg [5 : 0] func, output reg [11 : 0] imm);

  `include "com/synflow/risc/RISCV_Definitions.v"

  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Task ID_decode_0 (line 16)
  task ID_decode_0(input [31 : 0] instr_in);
    reg [31 : 0] instr_l;
    reg [31 : 0] local_instr;
    reg [6 : 0] opcode_l;
    reg [8 : 0] flags_l;
    reg [6 : 0] local_RISCV_LOAD;
    reg [6 : 0] local_RISCV_STORE;
    reg signed [11 : 0] imm_l;
    reg [6 : 0] local_RISCV_OP_IMM;
    reg [6 : 0] local_RISCV_OP_IMM_32;
    reg [4 : 0] rd_l;
    reg [6 : 0] local_RISCV_BRANCH;
    reg [6 : 0] local_RISCV_J;
    reg [6 : 0] local_RISCV_JAL;
    reg [11 : 0] _expr;
    reg [21 : 0] _expr0;
    reg [6 : 0] _expr1;
    reg [4 : 0] rd_out;
    reg [8 : 0] flags_out;
    reg signed [11 : 0] imm_out;
  begin
    local_RISCV_LOAD = RISCV_LOAD;
    local_RISCV_STORE = RISCV_STORE;
    local_RISCV_OP_IMM = RISCV_OP_IMM;
    local_RISCV_OP_IMM_32 = RISCV_OP_IMM_32;
    local_RISCV_BRANCH = RISCV_BRANCH;
    local_RISCV_J = RISCV_J;
    local_RISCV_JAL = RISCV_JAL;
    local_instr = instr_in;
    instr_l = local_instr;
    opcode_l = instr_l;
    flags_l = 9'h000;
    if ((opcode_l == local_RISCV_LOAD)) begin
      flags_l = (flags_l | 9'h001);
    end
    else begin
      flags_l = (flags_l & 9'h1fe);
    end
    if ((opcode_l == local_RISCV_STORE)) begin
      flags_l = (flags_l | 9'h002);
    end
    else begin
      flags_l = (flags_l & 9'h1fd);
    end
    imm_l = $signed(12'h000);
    $display("opcode = %0h", opcode_l);
    if ((((opcode_l == local_RISCV_OP_IMM) || (opcode_l == local_RISCV_OP_IMM_32)) || (opcode_l == local_RISCV_LOAD))) begin
      imm_l = instr_l >> 4'ha;
      flags_l = (flags_l | 9'h004);
    end
    else begin
      if ((opcode_l == local_RISCV_STORE)) begin
        _expr = instr_l >> 5'h14;
        _expr0 = instr_l >> 4'ha;
        _expr1 = (_expr0 & 7'h7f);
        imm_l = $signed((_expr | _expr1));
        flags_l = (flags_l | 9'h004);
      end
    end
    $display("imm = %0h", imm_l);
    if (((((opcode_l == local_RISCV_STORE) || (opcode_l == local_RISCV_BRANCH)) || (opcode_l == local_RISCV_J)) || (opcode_l == local_RISCV_JAL))) begin
      rd_l = 5'h00;
    end
    else begin
      rd_l = instr_l >> 5'h1b;
    end
    rd_out = rd_l;
    $display("flags: %0h", flags_l);
    flags_out = flags_l;
    imm_out = imm_l;
    rd <= rd_out;
    flags <= flags_out;
    imm <= imm_out;
  end
  endtask
  

  /**
   * Synchronous process
   */
  always @(negedge reset_n or posedge clock) begin // body of ID_decode
    if (~reset_n) begin
      rd <= 0;
      flags <= 0;
      func <= 0;
      imm <= 0;
    end else begin
      //
      if (1) begin
        // Body of ID_decode_0 (line 16)
        ID_decode_0(instr);
      end
    end
  end

endmodule //ID_decode
