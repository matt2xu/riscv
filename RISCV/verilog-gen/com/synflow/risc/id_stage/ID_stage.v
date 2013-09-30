/**
 * Title      : Generated from com.synflow.risc.id_stage.ID_stage by Synflow Studio
 * Project    : RISCV
 *
 * File       : com.synflow.risc.id_stage.ID_stage.v
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module ID_stage(input clock, input reset_n, input [31 : 0] instr, input [4 : 0] previous_rd, input [31 : 0] previous_data, input previous_data_send, output [31 : 0] val1, output [31 : 0] val2, output [4 : 0] rd, output [8 : 0] flags, output [5 : 0] func, output [11 : 0] imm);

  /**
   * Wires
   */
  // Module : decode_rs
  wire [4 : 0] decode_rs_rs1;
  wire [4 : 0] decode_rs_rs2;
  // Module : control_rd
  wire [4 : 0] control_rd_rd_o;
  wire [31 : 0] control_rd_data_o;
  wire control_rd_data_o_send;

  /**
   * Instances
   */
  ID_decode_rs decode_rs (
    .instr(instr),
    .rs1(decode_rs_rs1),
    .rs2(decode_rs_rs2)
  );
  
  RegFile regFile (
    .clock(clock),
    .reset_n(reset_n),
    .rs1(decode_rs_rs1),
    .rs2(decode_rs_rs2),
    .rd(control_rd_rd_o),
    .data(control_rd_data_o),
    .data_send(control_rd_data_o_send),
    .op1(val1),
    .op2(val2)
  );
  
  ID_decode decode (
    .clock(clock),
    .reset_n(reset_n),
    .instr(instr),
    .rd_o(rd),
    .flags_o(flags),
    .func_o(func),
    .imm_o(imm)
  );
  
  ID_control_rd control_rd (
    .rd_i(previous_rd),
    .data_i(previous_data),
    .data_i_send(previous_data_send),
    .rd_o(control_rd_rd_o),
    .data_o(control_rd_data_o),
    .data_o_send(control_rd_data_o_send)
  );

  /**
   * Assignments to output ports
   */

endmodule //ID_stage
