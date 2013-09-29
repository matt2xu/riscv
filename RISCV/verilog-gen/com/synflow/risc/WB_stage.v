/**
 * Title      : Generated from com.synflow.risc.WB_stage by Synflow Studio
 * Project    : RISCV
 *
 * File       : WB_stage.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module WB_stage(input [4 : 0] rd_i, input [31 : 0] value_i, output reg [4 : 0] rd_o, output reg [31 : 0] value_o);


  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Task WB_stage_0 (line 16)
  task WB_stage_0(input [4 : 0] rd_i_in, input [31 : 0] value_i_in);
    reg [4 : 0] local_rd_i;
    reg [31 : 0] local_value_i;
    reg [4 : 0] rd_o_out;
    reg [31 : 0] value_o_out;
  begin
    local_rd_i = rd_i_in;
    rd_o_out = local_rd_i;
    local_value_i = value_i_in;
    value_o_out = local_value_i;
    rd_o <= rd_o_out;
    value_o <= value_o_out;
  end
  endtask
  

  /**
   * Asynchronous process
   */
  always @(*) begin
    rd_o <= 0;
    value_o <= 0;
    //
    if (1) begin
      // Body of WB_stage_0 (line 16)
      WB_stage_0(rd_i, value_i);
    end
  end

endmodule //WB_stage
