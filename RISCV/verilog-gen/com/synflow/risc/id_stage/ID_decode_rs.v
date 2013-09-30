/**
 * Title      : Generated from com.synflow.risc.id_stage.ID_decode_rs by Synflow Studio
 * Project    : RISCV
 *
 * File       : ID_decode_rs.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module ID_decode_rs(input [31 : 0] instr, output reg [4 : 0] rs1, output reg [4 : 0] rs2);


  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Task ID_decode_rs_0 (line 16)
  task ID_decode_rs_0(input [31 : 0] instr_in);
    reg [31 : 0] inst;
    reg [31 : 0] local_instr;
    reg [4 : 0] rs1_out;
    reg [4 : 0] rs2_out;
  begin
    local_instr = instr_in;
    inst = local_instr;
    rs1_out = inst >> 5'h16;
    rs2_out = inst >> 5'h11;
    rs1 <= rs1_out;
    rs2 <= rs2_out;
  end
  endtask
  

  /**
   * Asynchronous process
   */
  always @(*) begin
    rs1 <= 0;
    rs2 <= 0;
    //
    if (1) begin
      // Body of ID_decode_rs_0 (line 16)
      ID_decode_rs_0(instr);
    end
  end

endmodule //ID_decode_rs
