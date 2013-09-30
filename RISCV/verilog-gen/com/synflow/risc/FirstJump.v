/**
 * Title      : Generated from com.synflow.risc.FirstJump by Synflow Studio
 * Project    : RISCV
 *
 * File       : FirstJump.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module FirstJump(input clock, input reset_n, output reg [31 : 0] pc, output reg pc_send);


  /**
   * State variables
   */


  /**
   * Behavior
   */

  /**
   * Synchronous process
   */
  always @(negedge reset_n or posedge clock) begin // body of FirstJump
    if (~reset_n) begin
      pc <= 0;
      pc_send <= 0;
    end else begin
      pc_send <= 0;
      //
    end
  end

endmodule //FirstJump
