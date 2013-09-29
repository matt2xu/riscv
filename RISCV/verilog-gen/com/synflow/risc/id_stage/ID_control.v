/**
 * Title      : Generated from com.synflow.risc.id_stage.ID_control by Synflow Studio
 * Project    : RISCV
 *
 * File       : ID_control.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module ID_control(input [31 : 0] instr, output reg [4 : 0] rs1, output reg [4 : 0] rs2, output reg [4 : 0] rd);


  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Task ID_control_0 (line 16)
  task ID_control_0(input [31 : 0] instr_in);
    reg [31 : 0] inst;
    reg [31 : 0] local_instr;
    reg [4 : 0] rd_local;
    reg [4 : 0] rs1_local;
    reg [4 : 0] rs2_local;
    reg [4 : 0] rs1_out;
    reg [4 : 0] rs2_out;
    reg [4 : 0] rd_out;
  begin
    local_instr = instr_in;
    inst = local_instr;
    rd_local = inst >> 5'h1b;
    rs1_local = inst >> 5'h16;
    rs2_local = inst >> 5'h11;
    rs1_out = rs1_local;
    rs2_out = rs2_local;
    rd_out = rd_local;
    rs1 <= rs1_out;
    rs2 <= rs2_out;
    rd <= rd_out;
  end
  endtask
  

  /**
   * Asynchronous process
   */
  always @(*) begin
    rs1 <= 0;
    rs2 <= 0;
    rd <= 0;
    //
    if (1) begin
      // Body of ID_control_0 (line 16)
      ID_control_0(instr);
    end
  end

endmodule //ID_control
