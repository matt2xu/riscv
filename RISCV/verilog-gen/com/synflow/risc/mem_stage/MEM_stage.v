/**
 * Title      : Generated from com.synflow.risc.mem_stage.MEM_stage by Synflow Studio
 * Project    : RISCV
 *
 * File       : com.synflow.risc.mem_stage.MEM_stage.v
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module MEM_stage(input clock, input reset_n, input [31 : 0] addr, input [31 : 0] value, input [4 : 0] rd_i, input [8 : 0] flags_i, output [4 : 0] rd_o, output [8 : 0] flags_o, output [31 : 0] fromMem, output [31 : 0] fromEx);

  /**
   * Wires
   */
  // Module : addr_control
  wire [15 : 0] addr_control_addr_o;
  wire [31 : 0] addr_control_data;
  wire addr_control_data_send;

  /**
   * Instances
   */
  Single_Port_RAM #(
    .depth(16),
    .width(32)
  )
  ram (
    .clock(clock),
    .reset_n(reset_n),
    .data(addr_control_data),
    .data_send(addr_control_data_send),
    .address(addr_control_addr_o),
    .q(fromMem)
  );
  
  MEM_addr_control addr_control (
    .addr_i(addr),
    .value(value),
    .flags(flags_i),
    .addr_o(addr_control_addr_o),
    .data(addr_control_data),
    .data_send(addr_control_data_send)
  );
  
  MEM_forward mem_forward (
    .clock(clock),
    .reset_n(reset_n),
    .rd_i(rd_i),
    .value_i(value),
    .flags_i(flags_i),
    .flags_o(flags_o),
    .rd_o(rd_o),
    .value_o(fromEx)
  );

  /**
   * Assignments to output ports
   */

endmodule //MEM_stage
