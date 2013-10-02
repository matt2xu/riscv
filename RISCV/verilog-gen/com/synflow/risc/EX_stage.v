/**
 * Title      : Generated from com.synflow.risc.EX_stage by Synflow Studio
 * Project    : RISCV
 *
 * File       : EX_stage.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module EX_stage(input clock, input reset_n, input [31 : 0] val1, input [31 : 0] val2, input [4 : 0] rd, input [8 : 0] flags_i, input [11 : 0] imm, output reg [31 : 0] addr, output reg [31 : 0] value, output reg [4 : 0] rd_o, output reg [8 : 0] flags_o);


  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Task EX_stage_0 (line 16)
  task EX_stage_0(input [8 : 0] flags_i_in, input [31 : 0] val1_in, input [31 : 0] val2_in, input signed [11 : 0] imm_in, input [4 : 0] rd_in);
    reg [8 : 0] flags_l;
    reg [8 : 0] local_flags_i;
    reg [31 : 0] val1_i_l;
    reg [31 : 0] local_val1;
    reg [31 : 0] val2_i_l;
    reg [31 : 0] local_val2;
    reg signed [11 : 0] imm_i_l;
    reg signed [11 : 0] local_imm;
    reg signed [31 : 0] signExtendedImm_l;
    reg [31 : 0] op1_l;
    reg [31 : 0] op2_l;
    reg signed [31 : 0] tmp_if;
    reg [31 : 0] res_l;
    reg [31 : 0] value_l;
    reg [31 : 0] addr_l;
    reg [4 : 0] local_rd;
    reg [8 : 0] _expr;
    reg [8 : 0] _expr0;
    reg [8 : 0] _expr1;
    reg [8 : 0] _expr2;
    reg [31 : 0] addr_out;
    reg [31 : 0] value_out;
    reg [4 : 0] rd_o_out;
    reg [8 : 0] flags_o_out;
  begin
    local_flags_i = flags_i_in;
    flags_l = local_flags_i;
    $display("flags: %0h", flags_l);
    local_val1 = val1_in;
    val1_i_l = local_val1;
    local_val2 = val2_in;
    val2_i_l = local_val2;
    local_imm = imm_in;
    imm_i_l = local_imm;
    $display("val1 = %0h & val2 = %0h", val1_i_l, val2_i_l);
    $display("imm = %0h", imm_i_l);
    signExtendedImm_l = imm_i_l;
    op1_l = val1_i_l;
    _expr = (flags_l & 9'h004);
    if ((_expr != 9'h000)) begin
      tmp_if = signExtendedImm_l;
    end
    else begin
      tmp_if = $signed(val2_i_l);
    end
    op2_l = $unsigned(tmp_if);
    res_l = (op1_l + op2_l);
    value_l = 32'h00000000;
    addr_l = 32'h00000000;
    _expr0 = (flags_l & 9'h001);
    _expr1 = (flags_l & 9'h002);
    if (((_expr0 != 9'h000) || (_expr1 != 9'h000))) begin
      addr_l = res_l;
    end
    _expr2 = (flags_l & 9'h002);
    if ((_expr2 != 9'h000)) begin
      value_l = val2_i_l;
    end
    else begin
      value_l = res_l;
    end
    $display("addr = %0h", addr_l);
    $display("value = %0h", value_l);
    addr_out = addr_l;
    value_out = value_l;
    local_rd = rd_in;
    rd_o_out = local_rd;
    flags_o_out = flags_l;
    addr <= addr_out;
    value <= value_out;
    rd_o <= rd_o_out;
    flags_o <= flags_o_out;
  end
  endtask
  

  /**
   * Synchronous process
   */
  always @(negedge reset_n or posedge clock) begin // body of EX_stage
    if (~reset_n) begin
      addr <= 0;
      value <= 0;
      rd_o <= 0;
      flags_o <= 0;
    end else begin
      //
      if (1) begin
        // Body of EX_stage_0 (line 16)
        EX_stage_0(flags_i, val1, val2, imm, rd);
      end
    end
  end

endmodule //EX_stage
