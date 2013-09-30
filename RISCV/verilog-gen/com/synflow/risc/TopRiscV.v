/**
 * Title      : Generated from com.synflow.risc.TopRiscV by Synflow Studio
 * Project    : RISCV
 *
 * File       : com.synflow.risc.TopRiscV.v
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module TopRiscV(input clock, input reset_n);

  /**
   * Wires
   */
  // Module : EX_stage
  wire [31 : 0] EX_stage_addr;
  wire [31 : 0] EX_stage_value;
  wire [4 : 0] EX_stage_rd_o;
  wire [8 : 0] EX_stage_flags_o;
  // Module : WB_stage
  wire [4 : 0] WB_stage_rd_o;
  wire [31 : 0] WB_stage_value_o;
  // Module : IF_stage
  wire [31 : 0] IF_stage_instr;
  // Module : ID_stage
  wire [31 : 0] ID_stage_val1;
  wire [31 : 0] ID_stage_val2;
  wire [4 : 0] ID_stage_rd;
  wire [8 : 0] ID_stage_flags;
  wire [11 : 0] ID_stage_imm;
  // Module : MEM_stage
  wire [4 : 0] MEM_stage_rd_o;
  wire [8 : 0] MEM_stage_flags_o;
  wire [31 : 0] MEM_stage_fromMem;
  wire [31 : 0] MEM_stage_fromEx;
  // Module : firstjump
  wire [31 : 0] firstjump_pc;
  wire firstjump_pc_send;

  /**
   * Instances
   */
  EX_stage EX_stage (
    .clock(clock),
    .reset_n(reset_n),
    .rd(ID_stage_rd),
    .flags_i(ID_stage_flags),
    .val1(ID_stage_val1),
    .val2(ID_stage_val2),
    .imm(ID_stage_imm),
    .addr(EX_stage_addr),
    .value(EX_stage_value),
    .rd_o(EX_stage_rd_o),
    .flags_o(EX_stage_flags_o)
  );
  
  WB_stage WB_stage (
    .rd_i(MEM_stage_rd_o),
    .fromMem(MEM_stage_fromMem),
    .fromEx(MEM_stage_fromEx),
    .flags(MEM_stage_flags_o),
    .rd_o(WB_stage_rd_o),
    .value_o(WB_stage_value_o)
  );
  
  IF_stage IF_stage (
    .clock(clock),
    .reset_n(reset_n),
    .pc_jump(firstjump_pc),
    .pc_jump_send(firstjump_pc_send),
    .pc(),
    .instr(IF_stage_instr)
  );
  
  ID_stage ID_stage (
    .clock(clock),
    .reset_n(reset_n),
    .instr(IF_stage_instr),
    .previous_data(WB_stage_value_o),
    .previous_data_send(1'b1),
    .previous_rd(WB_stage_rd_o),
    .val1(ID_stage_val1),
    .val2(ID_stage_val2),
    .rd(ID_stage_rd),
    .flags(ID_stage_flags),
    .func(),
    .imm(ID_stage_imm)
  );
  
  MEM_stage MEM_stage (
    .clock(clock),
    .reset_n(reset_n),
    .flags_i(EX_stage_flags_o),
    .rd_i(EX_stage_rd_o),
    .addr(EX_stage_addr),
    .value(EX_stage_value),
    .rd_o(MEM_stage_rd_o),
    .flags_o(MEM_stage_flags_o),
    .fromMem(MEM_stage_fromMem),
    .fromEx(MEM_stage_fromEx)
  );
  
  FirstJump firstjump (
    .clock(clock),
    .reset_n(reset_n),
    .pc(firstjump_pc),
    .pc_send(firstjump_pc_send)
  );

  /**
   * Assignments to output ports
   */

endmodule //TopRiscV
