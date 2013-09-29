/**
 * Title      : Generated from com.synflow.risc.mem_stage.MEM_mux_q by Synflow Studio
 * Project    : RISCV
 *
 * File       : MEM_mux_q.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module MEM_mux_q(input [1 : 0] memOp, input [31 : 0] value, output reg [31 : 0] data);


  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Scheduler of MEM_mux_q_0_a (line 17)
  function isSchedulable_MEM_mux_q_0_a(input [1 : 0] memOp_in);
  reg [1 : 0] ops;
  reg [1 : 0] local_memOp;
  reg [1 : 0] _expr;
  begin
    local_memOp = memOp_in;
    ops = local_memOp;
    _expr = (ops & 2'h1);
    isSchedulable_MEM_mux_q_0_a = (_expr != 2'h0);
  end
  endfunction
  
  // Task MEM_mux_q_0_a (line 17)
  task MEM_mux_q_0_a(input [1 : 0] memOp_in, input [31 : 0] value_in);
    reg [1 : 0] ops;
    reg [1 : 0] local_memOp;
    reg [31 : 0] local_value;
    reg [31 : 0] data_out;
  begin
    local_memOp = memOp_in;
    ops = local_memOp;
    local_value = value_in;
    data_out = local_value;
    data <= data_out;
  end
  endtask
  
  // Scheduler of MEM_mux_q_0_b (line 0)
  function isSchedulable_MEM_mux_q_0_b(input [1 : 0] memOp_in);
  reg [1 : 0] ops;
  reg [1 : 0] local_memOp;
  begin
    local_memOp = memOp_in;
    ops = local_memOp;
    isSchedulable_MEM_mux_q_0_b = 1;
  end
  endfunction
  
  // Task MEM_mux_q_0_b (line 0)
  task MEM_mux_q_0_b(input [1 : 0] memOp_in);
    reg [1 : 0] ops;
    reg [1 : 0] local_memOp;
  begin
    local_memOp = memOp_in;
    ops = local_memOp;
  end
  endtask
  

  /**
   * Asynchronous process
   */
  always @(*) begin
    data <= 0;
    //
    if (isSchedulable_MEM_mux_q_0_a(memOp)) begin
      // Body of MEM_mux_q_0_a (line 17)
      MEM_mux_q_0_a(memOp, value);
    end else if (isSchedulable_MEM_mux_q_0_b(memOp)) begin
      // Body of MEM_mux_q_0_b (line 0)
      MEM_mux_q_0_b(memOp);
    end
  end

endmodule //MEM_mux_q
