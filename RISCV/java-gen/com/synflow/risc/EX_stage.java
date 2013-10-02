package com.synflow.risc;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;

@SuppressWarnings("all")
final public class EX_stage implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(EX_stage.class, args).run();
	}

	private final String _name;

	// fields


	// ports
	private Port val1;
	private Port val2;
	private Port rd;
	private Port flags_i;
	private Port imm;
	private final Port addr;
	private final Port value;
	private final Port rd_o;
	private final Port flags_o;

	/**
	 * constructor
	 */
	public EX_stage(String name, int _flags) {
		this._name = name;
		val1 = new Port(this, "val1", 32, _flags);
		val2 = new Port(this, "val2", 32, _flags);
		rd = new Port(this, "rd", 5, _flags);
		flags_i = new Port(this, "flags_i", 9, _flags);
		imm = new Port(this, "imm", 12, _flags);
		addr = new Port(this, "addr", 32, _flags);
		value = new Port(this, "value", 32, _flags);
		rd_o = new Port(this, "rd_o", 5, _flags);
		flags_o = new Port(this, "flags_o", 9, _flags);
	}


	@Override
	public void commit() {
		addr.commit();
		value.commit();
		rd_o.commit();
		flags_o.commit();
	
	}

	@Override
	public void connect(Port... ports) {
		this.val1 = ports[0];
		this.val2 = ports[1];
		this.rd = ports[2];
		this.flags_i = ports[3];
		this.imm = ports[4];

		val1.connect();
		val2.connect();
		rd.connect();
		flags_i.connect();
		imm.connect();
	}

	@Override
	public void execute() {
		boolean isSchedulable = false;
		int val1_in;
		int val2_in;
		int rd_in;
		int flags_i_in;
		int imm_in;
		int addr_out;
		int value_out;
		int rd_o_out;
		int flags_o_out;
	
		if (flags_i.available() && val1.available() && val2.available() && imm.available() && rd.available()) {
			flags_i_in = flags_i.peekInt(); // (line 16)
			val1_in = val1.peekInt(); // (line 16)
			val2_in = val2.peekInt(); // (line 16)
			imm_in = imm.peekInt(); // (line 16)
			rd_in = rd.peekInt(); // (line 16)
			isSchedulable = true;
		}
		if (isSchedulable) {
			// action EX_stage_0 (line 16)
			int flags_l = 0;
			int local_flags_i = 0;
			int val1_i_l = 0;
			int local_val1 = 0;
			int val2_i_l = 0;
			int local_val2 = 0;
			int imm_i_l = 0;
			int local_imm = 0;
			int signExtendedImm_l = 0;
			int op1_l = 0;
			int op2_l = 0;
			int tmp_if = 0;
			int res_l = 0;
			int value_l = 0;
			int addr_l = 0;
			int local_rd = 0;
			flags_i_in = flags_i.readInt(); // (line 16)
			val1_in = val1.readInt(); // (line 16)
			val2_in = val2.readInt(); // (line 16)
			imm_in = imm.readInt(); // (line 16)
			rd_in = rd.readInt(); // (line 16)
			local_flags_i = flags_i_in; // (line 16)
			flags_l = local_flags_i; // (line 0)
			System.out.println(this + ": " + "flags: " + "0x" + Integer.toHexString(flags_l)); // (line 17)
			local_val1 = val1_in; // (line 19)
			val1_i_l = local_val1; // (line 0)
			local_val2 = val2_in; // (line 19)
			val2_i_l = local_val2; // (line 0)
			local_imm = imm_in; // (line 20)
			imm_i_l = local_imm; // (line 0)
			System.out.println(this + ": " + "val1 = " + "0x" + Integer.toHexString(val1_i_l) + " & val2 = " + "0x" + Integer.toHexString(val2_i_l)); // (line 22)
			System.out.println(this + ": " + "imm = " + "0x" + Integer.toHexString(imm_i_l)); // (line 23)
			signExtendedImm_l = (imm_i_l); // (line 0)
			op1_l = val1_i_l; // (line 0)
			if ((flags_l & 0x4) != 0x0) {
				tmp_if = signExtendedImm_l; // (line 0)
			} else {
				tmp_if = ((val2_i_l ^ 0x80000000) - 0x80000000); // (line 0)
			}
			op2_l = tmp_if; // (line 0)
			res_l = ((int) ((((long) (op1_l)) & 0xffffffffL) + (((long) (op2_l)) & 0xffffffffL)) & 0xffffffff); // (line 0)
			value_l = 0x0; // (line 0)
			addr_l = 0x0; // (line 0)
			if ((flags_l & 0x1) != 0x0 || (flags_l & 0x2) != 0x0) {
				addr_l = res_l; // (line 0)
			}
			if ((flags_l & 0x2) != 0x0) {
				value_l = val2_i_l; // (line 0)
			} else {
				value_l = res_l; // (line 0)
			}
			System.out.println(this + ": " + "addr = " + "0x" + Integer.toHexString(addr_l)); // (line 40)
			System.out.println(this + ": " + "value = " + "0x" + Integer.toHexString(value_l)); // (line 41)
			addr_out = addr_l; // (line 42)
			value_out = value_l; // (line 43)
			local_rd = rd_in; // (line 44)
			rd_o_out = local_rd; // (line 44)
			flags_o_out = flags_l; // (line 45)
			addr.write(addr_out);
			value.write(value_out);
			rd_o.write(rd_o_out);
			flags_o.write(flags_o_out);
		
			return;
		}
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[0];
	}

	@Override
	public Port[] getInputs() {
		return new Port[] { val1, val2, rd, flags_i, imm };
	}

	public Port getVal1() {
		return val1;
	}
	public Port getVal2() {
		return val2;
	}
	public Port getRd() {
		return rd;
	}
	public Port getFlags_i() {
		return flags_i;
	}
	public Port getImm() {
		return imm;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] { addr, value, rd_o, flags_o };
	}

	public Port getAddr() {
		return addr;
	}
	public Port getValue() {
		return value;
	}
	public Port getRd_o() {
		return rd_o;
	}
	public Port getFlags_o() {
		return flags_o;
	}

	@Override
	public String toString() {
		return _name;
	}

}
