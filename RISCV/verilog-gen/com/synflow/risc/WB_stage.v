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

module WB_stage(input [4 : 0] rd_i, input [8 : 0] flags, input [31 : 0] fromMem, input [31 : 0] fromEx, output reg [4 : 0] rd_o, output reg [31 : 0] value_o);


  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Task WB_stage_0 (line 16)
  task WB_stage_0(input [4 : 0] rd_i_in, input [8 : 0] flags_in, input [31 : 0] fromMem_in, input [31 : 0] fromEx_in);
    reg [4 : 0] local_rd_i;
    reg [8 : 0] flags_i;
    reg [8 : 0] local_flags;
    reg [31 : 0] tmp_if;
    reg [31 : 0] local_fromMem;
    reg [31 : 0] local_fromEx;
    reg [8 : 0] _expr;
    reg [4 : 0] rd_o_out;
    reg [31 : 0] value_o_out;
  begin
    local_rd_i = rd_i_in;
    rd_o_out = local_rd_i;
    local_flags = flags_in;
    flags_i = local_flags;
    _expr = (flags_i & 9'h001);
    if ((_expr != 9'h000)) begin
      local_fromMem = fromMem_in;
      tmp_if = local_fromMem;
    end
    else begin
      local_fromEx = fromEx_in;
      tmp_if = local_fromEx;
    end
    value_o_out = tmp_if;
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
      WB_stage_0(rd_i, flags, fromMem, fromEx);
    end
  end

endmodule //WB_stage
