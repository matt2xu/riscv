/**
 * Title      : Generated from com.synflow.risc.id_stage.ID_control_rd by Synflow Studio
 * Project    : RISCV
 *
 * File       : ID_control_rd.vhd
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */

module ID_control_rd(input [4 : 0] rd, input [31 : 0] data, input data_send, output reg [4 : 0] rd_o, output reg [31 : 0] data_o, output reg data_o_send);


  /**
   * State variables
   */


  /**
   * Behavior
   */
  // Scheduler of ID_control_rd_0_a (line 17)
  function isSchedulable_ID_control_rd_0_a(input [31 : 0] data_in, input [4 : 0] rd_in);
  reg [4 : 0] local_rd;
  begin
    local_rd = rd_in;
    isSchedulable_ID_control_rd_0_a = (local_rd != 5'h00);
  end
  endfunction
  
  // Task ID_control_rd_0_a (line 17)
  task ID_control_rd_0_a(input [4 : 0] rd_in, input [31 : 0] data_in);
    reg [4 : 0] local_rd;
    reg [31 : 0] local_data;
    reg [4 : 0] rd_o_out;
    reg [31 : 0] data_o_out;
  begin
    local_rd = rd_in;
    rd_o_out = local_rd;
    local_data = data_in;
    data_o_out = local_data;
    rd_o <= rd_o_out;
    data_o <= data_o_out;
    data_o_send <= 1;
  end
  endtask
  
  // Task ID_control_rd_0_b (line 0)
  task ID_control_rd_0_b(input [4 : 0] rd_in);
  begin
  end
  endtask
  

  /**
   * Asynchronous process
   */
  always @(*) begin
    rd_o <= 0;
    data_o <= 0;
    data_o_send <= 0;
    //
    if (data_send && isSchedulable_ID_control_rd_0_a(data, rd)) begin
      // Body of ID_control_rd_0_a (line 17)
      ID_control_rd_0_a(rd, data);
    end else if (1) begin
      // Body of ID_control_rd_0_b (line 0)
      ID_control_rd_0_b(rd);
    end
  end

endmodule //ID_control_rd
