/**
 * Title      : Generated from com.synflow.risc.mem_stage.MEM_forward by Synflow Studio
 * Project    : RISCV
 *
 * File       : MEM_forward.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module MEM_forward(input clock, input reset_n, input [4 : 0] rd_i, output reg [4 : 0] rd_o);


  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Task MEM_forward_0 (line 16)
  task MEM_forward_0(input [4 : 0] rd_i_in);
    reg [4 : 0] local_rd_i;
    reg [4 : 0] rd_o_out;
  begin
    local_rd_i = rd_i_in;
    rd_o_out = local_rd_i;
    rd_o <= rd_o_out;
  end
  endtask
  

  /**
   * Synchronous process
   */
  always @(negedge reset_n or posedge clock) begin // body of MEM_forward
    if (~reset_n) begin
      rd_o <= 0;
    end else begin
      //
      if (1) begin
        // Body of MEM_forward_0 (line 16)
        MEM_forward_0(rd_i);
      end
    end
  end

endmodule //MEM_forward
