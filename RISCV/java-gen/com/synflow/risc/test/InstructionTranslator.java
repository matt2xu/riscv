package com.synflow.risc.test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;
import static com.synflow.risc.RISCV_Definitions.*;

@SuppressWarnings("all")
final public class InstructionTranslator implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(InstructionTranslator.class, args).run();
	}

	private final String _name;

	// fields

	private int _state;

	// ports
	private Port unused;

	/**
	 * constructor
	 */
	public InstructionTranslator(String name, int _flags) {
		this._name = name;
		unused = new Port(this, "unused", 8, _flags);
	}

	private int lw(int rd, int rs1, int imm12) {
		int local_RISCV_LOAD = 0;
		local_RISCV_LOAD = RISCV_LOAD; // (line 13)
		return ((((((((rd) & 0x1f) << 0x1b)) | (((((rs1) & 0x1f) << 0x16)) & 0x7ffffff) ^ 0x80000000) - 0x80000000) | (((imm12) << 0xa))) | (((0x2 << 0x7)) & 0x1ff)) | ((local_RISCV_LOAD) & 0x7f);
	}

	@Override
	public void commit() {
	
	}

	@Override
	public void connect(Port... ports) {
		this.unused = ports[0];

		unused.connect();
	}

	@Override
	public void execute() {
		boolean isSchedulable = false;
		int unused_in;
	
		switch (_state) {
		case 0:
			if (true) {
				isSchedulable = true;
			}
			if (isSchedulable) {
				// action InstructionTranslator_0 (line 34)
				int rd = 0;
				int rs1 = 0;
				int imm = 0;
				int local_RISCV_OP_IMM = 0;
				int rd0 = 0;
				int rs10 = 0;
				int imm0 = 0;
				int local_RISCV_OP_IMM0 = 0;
				int rd1 = 0;
				int rs11 = 0;
				int imm1 = 0;
				int local_RISCV_OP_IMM1 = 0;
				int rd2 = 0;
				int rs12 = 0;
				int imm2 = 0;
				int local_RISCV_OP_IMM2 = 0;
				int rd3 = 0;
				int rs13 = 0;
				int imm3 = 0;
				int local_RISCV_OP_IMM3 = 0;
				int rd4 = 0;
				int rs14 = 0;
				int rs2 = 0;
				int local_RISCV_OP = 0;
				rd = 0x1; // (line 0)
				rs1 = 0x0; // (line 0)
				imm = 0x5; // (line 0)
				System.out.println(this + ": " + "addi " + "0x" + Integer.toHexString(rd) + " " + "0x" + Integer.toHexString(rs1) + " " + "0x" + Integer.toHexString(imm)); // (line 22)
				local_RISCV_OP_IMM = RISCV_OP_IMM; // (line 23)
				System.out.println(this + ": " + "0x" + Integer.toHexString((((((((rd) & 0x1f) << 0x1b)) | (((((rs1) & 0x1f) << 0x16)) & 0x7ffffff) ^ 0x80000000) - 0x80000000) | (((imm) << 0xa))) | ((local_RISCV_OP_IMM) & 0x7f))); // (line 23)
				rd0 = 0x2; // (line 0)
				rs10 = 0x0; // (line 0)
				imm0 = 0x8; // (line 0)
				System.out.println(this + ": " + "addi " + "0x" + Integer.toHexString(rd0) + " " + "0x" + Integer.toHexString(rs10) + " " + "0x" + Integer.toHexString(imm0)); // (line 22)
				local_RISCV_OP_IMM0 = RISCV_OP_IMM; // (line 23)
				System.out.println(this + ": " + "0x" + Integer.toHexString((((((((rd0) & 0x1f) << 0x1b)) | (((((rs10) & 0x1f) << 0x16)) & 0x7ffffff) ^ 0x80000000) - 0x80000000) | (((imm0) << 0xa))) | ((local_RISCV_OP_IMM0) & 0x7f))); // (line 23)
				rd1 = 0x0; // (line 0)
				rs11 = 0x0; // (line 0)
				imm1 = 0x0; // (line 0)
				System.out.println(this + ": " + "addi " + "0x" + Integer.toHexString(rd1) + " " + "0x" + Integer.toHexString(rs11) + " " + "0x" + Integer.toHexString(imm1)); // (line 22)
				local_RISCV_OP_IMM1 = RISCV_OP_IMM; // (line 23)
				System.out.println(this + ": " + "0x" + Integer.toHexString((((((((rd1) & 0x1f) << 0x1b)) | (((((rs11) & 0x1f) << 0x16)) & 0x7ffffff) ^ 0x80000000) - 0x80000000) | (((imm1) << 0xa))) | ((local_RISCV_OP_IMM1) & 0x7f))); // (line 23)
				rd2 = 0x0; // (line 0)
				rs12 = 0x0; // (line 0)
				imm2 = 0x0; // (line 0)
				System.out.println(this + ": " + "addi " + "0x" + Integer.toHexString(rd2) + " " + "0x" + Integer.toHexString(rs12) + " " + "0x" + Integer.toHexString(imm2)); // (line 22)
				local_RISCV_OP_IMM2 = RISCV_OP_IMM; // (line 23)
				System.out.println(this + ": " + "0x" + Integer.toHexString((((((((rd2) & 0x1f) << 0x1b)) | (((((rs12) & 0x1f) << 0x16)) & 0x7ffffff) ^ 0x80000000) - 0x80000000) | (((imm2) << 0xa))) | ((local_RISCV_OP_IMM2) & 0x7f))); // (line 23)
				rd3 = 0x0; // (line 0)
				rs13 = 0x0; // (line 0)
				imm3 = 0x0; // (line 0)
				System.out.println(this + ": " + "addi " + "0x" + Integer.toHexString(rd3) + " " + "0x" + Integer.toHexString(rs13) + " " + "0x" + Integer.toHexString(imm3)); // (line 22)
				local_RISCV_OP_IMM3 = RISCV_OP_IMM; // (line 23)
				System.out.println(this + ": " + "0x" + Integer.toHexString((((((((rd3) & 0x1f) << 0x1b)) | (((((rs13) & 0x1f) << 0x16)) & 0x7ffffff) ^ 0x80000000) - 0x80000000) | (((imm3) << 0xa))) | ((local_RISCV_OP_IMM3) & 0x7f))); // (line 23)
				rd4 = 0x3; // (line 0)
				rs14 = 0x1; // (line 0)
				rs2 = 0x2; // (line 0)
				System.out.println(this + ": " + "add " + "0x" + Integer.toHexString(rd4) + " " + "0x" + Integer.toHexString(rs14) + " " + "0x" + Integer.toHexString(rs2)); // (line 17)
				local_RISCV_OP = RISCV_OP; // (line 18)
				System.out.println(this + ": " + "0x" + Integer.toHexString(((((((rd4) & 0x1f) << 0x1b)) | (((((rs14) & 0x1f) << 0x16)) & 0x7ffffff)) | (((((rs2) & 0x1f) << 0x11)) & 0x3fffff)) | ((local_RISCV_OP) & 0x7f))); // (line 18)
			
				_state = 1;
				return;
			}
			break;
		case 1:
			break;
		}
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[0];
	}

	@Override
	public Port[] getInputs() {
		return new Port[] { unused };
	}

	public Port getUnused() {
		return unused;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] {  };
	}


	@Override
	public String toString() {
		return _name;
	}

}
