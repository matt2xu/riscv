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
	private final Port rd_o;
	private final Port flags_o;
	private final Port func_o;
	private final Port imm_o;

	/**
	 * constructor
	 */
	public ID_decode(String name, int _flags) {
		this._name = name;
		instr = new Port(this, "instr", 32, _flags);
		rd_o = new Port(this, "rd_o", 5, _flags);
		flags_o = new Port(this, "flags_o", 9, _flags);
		func_o = new Port(this, "func_o", 6, _flags);
		imm_o = new Port(this, "imm_o", 12, _flags);
	}


	@Override
	public void commit() {
		rd_o.commit();
		flags_o.commit();
		func_o.commit();
		imm_o.commit();
	
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
		int rd_o_out;
		int flags_o_out;
		int func_o_out;
		int imm_o_out;
	
		if (instr.available()) {
			instr_in = instr.peekInt(); // (line 16)
			isSchedulable = true;
		}
		if (isSchedulable) {
			// action ID_decode_0 (line 16)
			int inst = 0;
			int local_instr = 0;
			int opcode = 0;
			int flags = 0;
			int local_RISCV_LOAD = 0;
			int local_RISCV_STORE = 0;
			int imm = 0;
			int local_RISCV_OP_IMM = 0;
			int local_RISCV_OP_IMM_32 = 0;
			int local_RISCV_LOAD0 = 0;
			int local_RISCV_STORE0 = 0;
			int rd = 0;
			int local_RISCV_STORE1 = 0;
			int local_RISCV_BRANCH = 0;
			int local_RISCV_J = 0;
			int local_RISCV_JAL = 0;
			instr_in = instr.readInt(); // (line 16)
			local_instr = instr_in; // (line 16)
			inst = local_instr; // (line 0)
			opcode = ((inst) & 0x7f); // (line 0)
			flags = 0x0; // (line 0)
			local_RISCV_LOAD = RISCV_LOAD; // (line 20)
			if (opcode == local_RISCV_LOAD) {
				flags = flags | 0x1; // (line 0)
			} else {
				flags = flags & 0x1fe; // (line 0)
			}
			local_RISCV_STORE = RISCV_STORE; // (line 21)
			if (opcode == local_RISCV_STORE) {
				flags = flags | 0x2; // (line 0)
			} else {
				flags = flags & 0x1fd; // (line 0)
			}
			imm = 0x0; // (line 0)
			System.out.println(this + ": " + "opcode = " + "0x" + Integer.toHexString(opcode)); // (line 24)
			local_RISCV_OP_IMM = RISCV_OP_IMM; // (line 25)
			local_RISCV_OP_IMM_32 = RISCV_OP_IMM_32; // (line 25)
			local_RISCV_LOAD0 = RISCV_LOAD; // (line 25)
			if (opcode == local_RISCV_OP_IMM || opcode == local_RISCV_OP_IMM_32 || opcode == local_RISCV_LOAD0) {
				imm = ((((inst >>> 0xa) & 0xfff) ^ 0x800) - 0x800); // (line 0)
				flags = flags | 0x4; // (line 0)
			} else {
				local_RISCV_STORE0 = RISCV_STORE; // (line 28)
				if (opcode == local_RISCV_STORE0) {
					imm = (((((inst >>> 0x14) & 0xfff)) | (((((inst >>> 0xa) & 0x7f)) & 0x7f) & 0x7f) ^ 0x800) - 0x800); // (line 0)
					flags = flags | 0x4; // (line 0)
				}
			}
			System.out.println(this + ": " + "imm = " + "0x" + Integer.toHexString(imm)); // (line 32)
			local_RISCV_STORE1 = RISCV_STORE; // (line 37)
			local_RISCV_BRANCH = RISCV_BRANCH; // (line 37)
			local_RISCV_J = RISCV_J; // (line 38)
			local_RISCV_JAL = RISCV_JAL; // (line 38)
			if (opcode == local_RISCV_STORE1 || opcode == local_RISCV_BRANCH || opcode == local_RISCV_J || opcode == local_RISCV_JAL) {
				rd = 0x0; // (line 0)
			} else {
				rd = (((inst >>> 0x1b) & 0x1f)); // (line 0)
			}
			rd_o_out = rd; // (line 44)
			System.out.println(this + ": " + "flags: " + "0x" + Integer.toHexString(flags)); // (line 45)
			flags_o_out = flags; // (line 46)
			imm_o_out = imm; // (line 47)
			rd_o.write(rd_o_out);
			flags_o.write(flags_o_out);
			imm_o.write(imm_o_out);
		
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
		return new Port[] { rd_o, flags_o, func_o, imm_o };
	}

	public Port getRd_o() {
		return rd_o;
	}
	public Port getFlags_o() {
		return flags_o;
	}
	public Port getFunc_o() {
		return func_o;
	}
	public Port getImm_o() {
		return imm_o;
	}

	@Override
	public String toString() {
		return _name;
	}

}
