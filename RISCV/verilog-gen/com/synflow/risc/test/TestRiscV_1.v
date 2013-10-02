/**
 * Title      : Generated from com.synflow.risc.test.TestRiscV_1 by Synflow Studio
 * Project    : RISCV
 *
 * File       : com.synflow.risc.test.TestRiscV_1.v
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module TestRiscV_1(input clock, input reset_n);

  /**
   * Wires
   */
  // Module : rom
  wire [31 : 0] rom_q;
  // Module : divby4
  wire [2 : 0] divby4_addr;

  /**
   * Instances
   */
  TopRiscV topriscv (
    .clock(clock),
    .reset_n(reset_n));
  
  ROM #(
    .depth(3),
    .width(32),
    .fileName("../verilog-gen/com/synflow/risc/test/TestRiscV_1_rom.hex")
  )
  rom (
    .clock(clock),
    .reset_n(reset_n),
    .address(divby4_addr),
    .q(rom_q)
  );
  
  DivBy4 divby4 (
    .pc(rom_q),
    .addr(divby4_addr)
  );

  /**
   * Assignments to output ports
   */

endmodule //TestRiscV_1
