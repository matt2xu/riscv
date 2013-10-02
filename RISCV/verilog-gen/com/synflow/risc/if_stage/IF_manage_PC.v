/**
 * Title      : Generated from com.synflow.risc.if_stage.IF_manage_PC by Synflow Studio
 * Project    : RISCV
 *
 * File       : IF_manage_PC.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module IF_manage_PC(input clock, input reset_n, input [31 : 0] pc_normal, input [31 : 0] pc_jump, input pc_jump_send, output reg [31 : 0] next_pc, output reg [31 : 0] pc);


  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Task IF_manage_PC_0_a (line 10)
  task IF_manage_PC_0_a(input [31 : 0] pc_jump_in);
    reg [31 : 0] new_pc;
    reg [31 : 0] local_pc_jump;
    reg [31 : 0] pc_out;
    reg [31 : 0] next_pc_out;
  begin
    local_pc_jump = pc_jump_in;
    new_pc = local_pc_jump;
    $display("writing new pc: %0h", new_pc);
    pc_out = new_pc;
    next_pc_out = (new_pc + 33'h000000004);
    pc <= pc_out;
    next_pc <= next_pc_out;
  end
  endtask
  
  // Task IF_manage_PC_0_b (line 0)
  task IF_manage_PC_0_b(input [31 : 0] pc_normal_in);
    reg [31 : 0] new_pc;
    reg [31 : 0] local_pc_normal;
    reg [31 : 0] pc_out;
    reg [31 : 0] next_pc_out;
  begin
    local_pc_normal = pc_normal_in;
    new_pc = local_pc_normal;
    $display("writing new pc: %0h", new_pc);
    pc_out = new_pc;
    next_pc_out = (new_pc + 33'h000000004);
    pc <= pc_out;
    next_pc <= next_pc_out;
  end
  endtask
  

  /**
   * Synchronous process
   */
  always @(negedge reset_n or posedge clock) begin // body of IF_manage_PC
    if (~reset_n) begin
      next_pc <= 0;
      pc <= 0;
    end else begin
      //
      if (pc_jump_send && 1) begin
        // Body of IF_manage_PC_0_a (line 10)
        IF_manage_PC_0_a(pc_jump);
      end else if (1) begin
        // Body of IF_manage_PC_0_b (line 0)
        IF_manage_PC_0_b(pc_normal);
      end
    end
  end

endmodule //IF_manage_PC
