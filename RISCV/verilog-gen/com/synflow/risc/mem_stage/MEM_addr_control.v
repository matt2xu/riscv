/**
 * Title      : Generated from com.synflow.risc.mem_stage.MEM_addr_control by Synflow Studio
 * Project    : RISCV
 *
 * File       : MEM_addr_control.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module MEM_addr_control(input [8 : 0] flags, input [31 : 0] addr_i, input [31 : 0] value, output reg [15 : 0] addr_o, output reg [31 : 0] data, output reg data_send);


  /**
   * State variables
   */
  reg [15 : 0] isSchedulable_MEM_addr_control_0_a_addr_o [0 : 0];
  initial $readmemh("../verilog-gen/com/synflow/risc/mem_stage/MEM_addr_control_isSchedulable_MEM_addr_control_0_a_addr_o.hex", isSchedulable_MEM_addr_control_0_a_addr_o);


  /**
   * Behavior
   */
  // Scheduler of MEM_addr_control_0_a (line 19)
  function isSchedulable_MEM_addr_control_0_a(input [31 : 0] addr_i_in, input [8 : 0] flags_in);
  reg [31 : 0] local_addr_i;
  reg [8 : 0] flags_l;
  reg [8 : 0] local_flags;
  reg [8 : 0] _expr;
  begin
    local_addr_i = addr_i_in;
    local_flags = flags_in;
    flags_l = local_flags;
    $display("flags: %0h", flags_l);
    _expr = (flags_l & 9'h002);
    isSchedulable_MEM_addr_control_0_a = (_expr != 9'h000);
  end
  endfunction
  
  // Task MEM_addr_control_0_a (line 19)
  task MEM_addr_control_0_a(input [31 : 0] addr_i_in, input [8 : 0] flags_in, input [31 : 0] value_in);
    reg [31 : 0] local_addr_i;
    reg [8 : 0] flags_l;
    reg [8 : 0] local_flags;
    reg [31 : 0] local_value;
    reg [15 : 0] addr_o_out;
    reg [31 : 0] data_out;
  begin
    local_addr_i = addr_i_in;
    addr_o_out = local_addr_i;
    local_flags = flags_in;
    flags_l = local_flags;
    $display("flags: %0h", flags_l);
    local_value = value_in;
    data_out = local_value;
    addr_o <= addr_o_out;
    data <= data_out;
    data_send <= 1;
  end
  endtask
  
  // Scheduler of MEM_addr_control_0_b (line 0)
  function isSchedulable_MEM_addr_control_0_b(input [31 : 0] addr_i_in, input [8 : 0] flags_in);
  reg [31 : 0] local_addr_i;
  reg [8 : 0] flags_l;
  reg [8 : 0] local_flags;
  begin
    local_addr_i = addr_i_in;
    local_flags = flags_in;
    flags_l = local_flags;
    $display("flags: %0h", flags_l);
    isSchedulable_MEM_addr_control_0_b = 1;
  end
  endfunction
  
  // Task MEM_addr_control_0_b (line 0)
  task MEM_addr_control_0_b(input [31 : 0] addr_i_in, input [8 : 0] flags_in);
    reg [31 : 0] local_addr_i;
    reg [8 : 0] flags_l;
    reg [8 : 0] local_flags;
    reg [15 : 0] addr_o_out;
  begin
    local_addr_i = addr_i_in;
    addr_o_out = local_addr_i;
    local_flags = flags_in;
    flags_l = local_flags;
    $display("flags: %0h", flags_l);
    addr_o <= addr_o_out;
  end
  endtask
  

  /**
   * Asynchronous process
   */
  always @(*) begin
    addr_o <= 0;
    data <= 0;
    data_send <= 0;
    //
    if (isSchedulable_MEM_addr_control_0_a(addr_i, flags)) begin
      // Body of MEM_addr_control_0_a (line 19)
      MEM_addr_control_0_a(addr_i, flags, value);
    end else if (isSchedulable_MEM_addr_control_0_b(addr_i, flags)) begin
      // Body of MEM_addr_control_0_b (line 0)
      MEM_addr_control_0_b(addr_i, flags);
    end
  end

endmodule //MEM_addr_control
