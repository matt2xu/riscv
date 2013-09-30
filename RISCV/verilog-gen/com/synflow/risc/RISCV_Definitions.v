/**
 * Title      : Generated from RISCV_Definitions by Synflow Studio
 * Project    : RISCV
 *
 * File       : RISCV_Definitions.tb.v
 * Author     : Matthieu
 * Standard   : Verilog-2001
 *
 **
 * Copyright (c) 2013
 **
 *
 */
 

/**
 * Types and Constants
 */
localparam [5 : 0] XLEN = 6'h20;
localparam [6 : 0] RISCV_LOAD = 7'h03;
localparam [6 : 0] RISCV_OP_IMM = 7'h13;
localparam [6 : 0] RISCV_OP_IMM_32 = 7'h1b;
localparam [6 : 0] RISCV_STORE = 7'h23;
localparam [6 : 0] RISCV_OP = 7'h33;
localparam [6 : 0] RISCV_LUI = 7'h37;
localparam [6 : 0] RISCV_OP_32 = 7'h3b;
localparam [6 : 0] RISCV_BRANCH = 7'h63;
localparam [6 : 0] RISCV_JALR = 7'h67;
localparam [6 : 0] RISCV_J = 7'h6b;
localparam [6 : 0] RISCV_JAL = 7'h6f;
localparam [1 : 0] LOAD = 2'h0;
localparam [1 : 0] STORE = 2'h1;
localparam [1 : 0] HAS_IMM = 2'h2;


