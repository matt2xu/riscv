/**
 * Title      : Generated from com.synflow.risc.if_stage.IF_stage by Synflow Studio
 * Project    : RISCV
 *
 * File       : com.synflow.risc.if_stage.IF_stage.v
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module IF_stage(input clock, input reset_n, input [31 : 0] pc_jump, input pc_jump_send, output [31 : 0] pc, output [31 : 0] instr);

  /**
   * Wires
   */
  // Module : manage_PC
  wire [31 : 0] manage_PC_next_pc;
  wire [31 : 0] manage_PC_pc;
  // Module : divby4
  wire [2 : 0] divby4_addr;

  /**
   * Instances
   */
  IF_manage_PC manage_PC (
    .clock(clock),
    .reset_n(reset_n),
    .pc_jump(pc_jump),
    .pc_jump_send(pc_jump_send),
    .pc_normal(manage_PC_next_pc),
    .next_pc(manage_PC_next_pc),
    .pc(manage_PC_pc)
  );
  
  ROM #(
    .depth(3),
    .width(32),
    .fileName("../verilog-gen/com/synflow/risc/if_stage/IF_stage_rom_instr.hex")
  )
  rom_instr (
    .clock(clock),
    .reset_n(reset_n),
    .address(divby4_addr),
    .q(instr)
  );
  
  DivBy4 divby4 (
    .pc(manage_PC_pc),
    .addr(divby4_addr)
  );

  /**
   * Assignments to output ports
   */
  assign pc = manage_PC_next_pc;

endmodule //IF_stage
