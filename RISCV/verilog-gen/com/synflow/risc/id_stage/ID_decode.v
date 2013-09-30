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

module ID_decode(input clock, input reset_n, input [31 : 0] instr, output reg [4 : 0] rd_o, output reg [8 : 0] flags_o, output reg [5 : 0] func_o, output reg [11 : 0] imm_o);

  `include "com/synflow/risc/RISCV_Definitions.v"

  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Task ID_decode_0 (line 16)
  task ID_decode_0(input [31 : 0] instr_in);
    reg [31 : 0] inst;
    reg [31 : 0] local_instr;
    reg [6 : 0] opcode;
    reg [8 : 0] flags;
    reg [6 : 0] local_RISCV_LOAD;
    reg [6 : 0] local_RISCV_STORE;
    reg signed [11 : 0] imm;
    reg [6 : 0] local_RISCV_OP_IMM;
    reg [6 : 0] local_RISCV_OP_IMM_32;
    reg [4 : 0] rd;
    reg [6 : 0] local_RISCV_BRANCH;
    reg [6 : 0] local_RISCV_J;
    reg [6 : 0] local_RISCV_JAL;
    reg [11 : 0] _expr;
    reg [21 : 0] _expr0;
    reg [6 : 0] _expr1;
    reg [4 : 0] rd_o_out;
    reg [8 : 0] flags_o_out;
    reg signed [11 : 0] imm_o_out;
  begin
    local_RISCV_LOAD = RISCV_LOAD;
    local_RISCV_STORE = RISCV_STORE;
    local_RISCV_OP_IMM = RISCV_OP_IMM;
    local_RISCV_OP_IMM_32 = RISCV_OP_IMM_32;
    local_RISCV_BRANCH = RISCV_BRANCH;
    local_RISCV_J = RISCV_J;
    local_RISCV_JAL = RISCV_JAL;
    local_instr = instr_in;
    inst = local_instr;
    opcode = inst;
    flags = 9'h000;
    if ((opcode == local_RISCV_LOAD)) begin
      flags = (flags | 9'h001);
    end
    else begin
      flags = (flags & 9'h1fe);
    end
    if ((opcode == local_RISCV_STORE)) begin
      flags = (flags | 9'h002);
    end
    else begin
      flags = (flags & 9'h1fd);
    end
    imm = $signed(12'h000);
    if ((((opcode == local_RISCV_OP_IMM) || (opcode == local_RISCV_OP_IMM_32)) || (opcode == local_RISCV_LOAD))) begin
      imm = inst >> 4'ha;
      flags = (flags | 9'h004);
    end
    else begin
      if ((opcode == local_RISCV_STORE)) begin
        _expr = inst >> 5'h14;
        _expr0 = inst >> 4'ha;
        _expr1 = (_expr0 & 7'h7f);
        imm = $signed((_expr | _expr1));
        flags = (flags | 9'h004);
      end
    end
    if (((((opcode == local_RISCV_STORE) || (opcode == local_RISCV_BRANCH)) || (opcode == local_RISCV_J)) || (opcode == local_RISCV_JAL))) begin
      rd = 5'h00;
    end
    else begin
      rd = inst >> 5'h1b;
    end
    rd_o_out = rd;
    flags_o_out = flags;
    imm_o_out = imm;
    rd_o <= rd_o_out;
    flags_o <= flags_o_out;
    imm_o <= imm_o_out;
  end
  endtask
  

  /**
   * Synchronous process
   */
  always @(negedge reset_n or posedge clock) begin // body of ID_decode
    if (~reset_n) begin
      rd_o <= 0;
      flags_o <= 0;
      func_o <= 0;
      imm_o <= 0;
    end else begin
      //
      if (1) begin
        // Body of ID_decode_0 (line 16)
        ID_decode_0(instr);
      end
    end
  end

endmodule //ID_decode
