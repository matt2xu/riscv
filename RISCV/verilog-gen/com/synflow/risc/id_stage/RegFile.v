/**
 * Title      : Generated from com.synflow.risc.id_stage.RegFile by Synflow Studio
 * Project    : RISCV
 *
 * File       : com.synflow.risc.id_stage.RegFile.v
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module RegFile(input clock, input reset_n, input [4 : 0] rs1, input [4 : 0] rs2, input [4 : 0] rd, input [31 : 0] data, input data_send, output [31 : 0] op1, output [31 : 0] op2);

  /**
   * Wires
   */

  /**
   * Instances
   */
  Dual_Port_RAM #(
    .depth(5),
    .width(32)
  )
  ram_2 (
    .rd_clock(clock),
    .wr_clock(clock),
    .reset_n(reset_n),
    .rd_address(rs2),
    .wr_address(rd),
    .data(data),
    .data_send(data_send),
    .q(op2)
  );
  
  Dual_Port_RAM #(
    .depth(5),
    .width(32)
  )
  ram_1 (
    .rd_clock(clock),
    .wr_clock(clock),
    .reset_n(reset_n),
    .rd_address(rs1),
    .wr_address(rd),
    .data(data),
    .data_send(data_send),
    .q(op1)
  );

  /**
   * Assignments to output ports
   */

endmodule //RegFile
