package com.synflow.risc.id_stage;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;
import static com.synflow.risc.RISCV_Definitions.*;

@SuppressWarnings("all")
final public class ID_decode implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(ID_decode.class, args).run();
	}

	private final String _name;

	// fields


	// ports
	private Port instr;
	private final Port rd;
	private final Port flags;
	private final Port func;
	private final Port imm;

	/**
	 * constructor
	 */
	public ID_decode(String name, int _flags) {
		this._name = name;
		instr = new Port(this, "instr", 32, _flags);
		rd = new Port(this, "rd", 5, _flags);
		flags = new Port(this, "flags", 9, _flags);
		func = new Port(this, "func", 6, _flags);
		imm = new Port(this, "imm", 12, _flags);
	}


	@Override
	public void commit() {
		rd.commit();
		flags.commit();
		func.commit();
		imm.commit();
	
	}

	@Override
	public void connect(Port... ports) {
		this.instr = ports[0];

		instr.connect();
	}

	@Override
	public void execute() {
		boolean isSchedulable = false;
		int instr_in;
		int rd_out;
		int flags_out;
		int func_out;
		int imm_out;
	
		if (instr.available()) {
			instr_in = instr.peekInt(); // (line 16)
			isSchedulable = true;
		}
		if (isSchedulable) {
			// action ID_decode_0 (line 16)
			int instr_l = 0;
			int local_instr = 0;
			int opcode_l = 0;
			int flags_l = 0;
			int local_RISCV_LOAD = 0;
			int local_RISCV_STORE = 0;
			int imm_l = 0;
			int local_RISCV_OP_IMM = 0;
			int local_RISCV_OP_IMM_32 = 0;
			int local_RISCV_LOAD0 = 0;
			int local_RISCV_STORE0 = 0;
			int rd_l = 0;
			int local_RISCV_STORE1 = 0;
			int local_RISCV_BRANCH = 0;
			int local_RISCV_J = 0;
			int local_RISCV_JAL = 0;
			instr_in = instr.readInt(); // (line 16)
			local_instr = instr_in; // (line 16)
			instr_l = local_instr; // (line 0)
			opcode_l = ((instr_l) & 0x7f); // (line 0)
			flags_l = 0x0; // (line 0)
			local_RISCV_LOAD = RISCV_LOAD; // (line 20)
			if (opcode_l == local_RISCV_LOAD) {
				flags_l = flags_l | 0x1; // (line 0)
			} else {
				flags_l = flags_l & 0x1fe; // (line 0)
			}
			local_RISCV_STORE = RISCV_STORE; // (line 21)
			if (opcode_l == local_RISCV_STORE) {
				flags_l = flags_l | 0x2; // (line 0)
			} else {
				flags_l = flags_l & 0x1fd; // (line 0)
			}
			imm_l = 0x0; // (line 0)
			System.out.println(this + ": " + "opcode = " + "0x" + Integer.toHexString(opcode_l)); // (line 24)
			local_RISCV_OP_IMM = RISCV_OP_IMM; // (line 25)
			local_RISCV_OP_IMM_32 = RISCV_OP_IMM_32; // (line 25)
			local_RISCV_LOAD0 = RISCV_LOAD; // (line 25)
			if (opcode_l == local_RISCV_OP_IMM || opcode_l == local_RISCV_OP_IMM_32 || opcode_l == local_RISCV_LOAD0) {
				imm_l = ((((instr_l >>> 0xa) & 0xfff) ^ 0x800) - 0x800); // (line 0)
				flags_l = flags_l | 0x4; // (line 0)
			} else {
				local_RISCV_STORE0 = RISCV_STORE; // (line 28)
				if (opcode_l == local_RISCV_STORE0) {
					imm_l = (((((instr_l >>> 0x14) & 0xfff)) | (((((instr_l >>> 0xa) & 0x7f)) & 0x7f) & 0x7f) ^ 0x800) - 0x800); // (line 0)
					flags_l = flags_l | 0x4; // (line 0)
				}
			}
			System.out.println(this + ": " + "imm = " + "0x" + Integer.toHexString(imm_l)); // (line 32)
			local_RISCV_STORE1 = RISCV_STORE; // (line 37)
			local_RISCV_BRANCH = RISCV_BRANCH; // (line 37)
			local_RISCV_J = RISCV_J; // (line 38)
			local_RISCV_JAL = RISCV_JAL; // (line 38)
			if (opcode_l == local_RISCV_STORE1 || opcode_l == local_RISCV_BRANCH || opcode_l == local_RISCV_J || opcode_l == local_RISCV_JAL) {
				rd_l = 0x0; // (line 0)
			} else {
				rd_l = (((instr_l >>> 0x1b) & 0x1f)); // (line 0)
			}
			rd_out = rd_l; // (line 44)
			System.out.println(this + ": " + "flags: " + "0x" + Integer.toHexString(flags_l)); // (line 45)
			flags_out = flags_l; // (line 46)
			imm_out = imm_l; // (line 47)
			rd.write(rd_out);
			flags.write(flags_out);
			imm.write(imm_out);
		
			return;
		}
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[0];
	}

	@Override
	public Port[] getInputs() {
		return new Port[] { instr };
	}

	public Port getInstr() {
		return instr;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] { rd, flags, func, imm };
	}

	public Port getRd() {
		return rd;
	}
	public Port getFlags() {
		return flags;
	}
	public Port getFunc() {
		return func;
	}
	public Port getImm() {
		return imm;
	}

	@Override
	public String toString() {
		return _name;
	}

}
