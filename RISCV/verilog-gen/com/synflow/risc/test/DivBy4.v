/**
 * Title      : Generated from com.synflow.risc.test.DivBy4 by Synflow Studio
 * Project    : RISCV
 *
 * File       : DivBy4.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module DivBy4(input [31 : 0] pc, output reg [2 : 0] addr);


  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Task DivBy4_0 (line 16)
  task DivBy4_0(input [31 : 0] pc_in);
    reg [31 : 0] local_pc;
    reg [2 : 0] addr_out;
  begin
    local_pc = pc_in;
    addr_out = local_pc >> 2'h2;
    addr <= addr_out;
  end
  endtask
  

  /**
   * Asynchronous process
   */
  always @(*) begin
    addr <= 0;
    //
    if (1) begin
      // Body of DivBy4_0 (line 16)
      DivBy4_0(pc);
    end
  end

endmodule //DivBy4
