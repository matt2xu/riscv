package com.synflow.risc.id_stage;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;

@SuppressWarnings("all")
final public class ID_decode_rs implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(ID_decode_rs.class, args).run();
	}

	private final String _name;

	// fields


	// ports
	private Port instr;
	private final Port rs1;
	private final Port rs2;

	/**
	 * constructor
	 */
	public ID_decode_rs(String name, int _flags) {
		this._name = name;
		instr = new Port(this, "instr", 32, _flags);
		rs1 = new Port(this, "rs1", 5, _flags);
		rs2 = new Port(this, "rs2", 5, _flags);
	}


	@Override
	public void commit() {
		rs1.commit();
		rs2.commit();
	
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
		int rs1_out;
		int rs2_out;
	
		if (instr.available()) {
			instr_in = instr.peekInt(); // (line 16)
			isSchedulable = true;
		}
		if (isSchedulable) {
			// action ID_decode_rs_0 (line 16)
			int inst_l = 0;
			int local_instr = 0;
			instr_in = instr.readInt(); // (line 16)
			local_instr = instr_in; // (line 16)
			inst_l = local_instr; // (line 0)
			rs1_out = (((inst_l >>> 0x16) & 0x1f)); // (line 17)
			rs2_out = (((inst_l >>> 0x11) & 0x1f)); // (line 18)
			rs1.write(rs1_out);
			rs2.write(rs2_out);
		
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
		return new Port[] { rs1, rs2 };
	}

	public Port getRs1() {
		return rs1;
	}
	public Port getRs2() {
		return rs2;
	}

	@Override
	public String toString() {
		return _name;
	}

}
