package com.synflow.risc.mem_stage;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;

@SuppressWarnings("all")
final public class MEM_forward implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(MEM_forward.class, args).run();
	}

	private final String _name;

	// fields


	// ports
	private Port flags_i;
	private Port rd_i;
	private Port value_i;
	private final Port flags_o;
	private final Port rd_o;
	private final Port value_o;

	/**
	 * constructor
	 */
	public MEM_forward(String name, int _flags) {
		this._name = name;
		flags_i = new Port(this, "flags_i", 9, _flags);
		rd_i = new Port(this, "rd_i", 5, _flags);
		value_i = new Port(this, "value_i", 32, _flags);
		flags_o = new Port(this, "flags_o", 9, _flags);
		rd_o = new Port(this, "rd_o", 5, _flags);
		value_o = new Port(this, "value_o", 32, _flags);
	}


	@Override
	public void commit() {
		flags_o.commit();
		rd_o.commit();
		value_o.commit();
	
	}

	@Override
	public void connect(Port... ports) {
		this.flags_i = ports[0];
		this.rd_i = ports[1];
		this.value_i = ports[2];

		flags_i.connect();
		rd_i.connect();
		value_i.connect();
	}

	@Override
	public void execute() {
		boolean isSchedulable = false;
		int flags_i_in;
		int rd_i_in;
		int value_i_in;
		int flags_o_out;
		int rd_o_out;
		int value_o_out;
	
		if (flags_i.available() && rd_i.available() && value_i.available()) {
			flags_i_in = flags_i.peekInt(); // (line 16)
			rd_i_in = rd_i.peekInt(); // (line 16)
			value_i_in = value_i.peekInt(); // (line 16)
			isSchedulable = true;
		}
		if (isSchedulable) {
			// action MEM_forward_0 (line 16)
			int local_flags_i = 0;
			int local_rd_i = 0;
			int local_value_i = 0;
			flags_i_in = flags_i.readInt(); // (line 16)
			rd_i_in = rd_i.readInt(); // (line 16)
			value_i_in = value_i.readInt(); // (line 16)
			local_flags_i = flags_i_in; // (line 16)
			flags_o_out = local_flags_i; // (line 16)
			local_rd_i = rd_i_in; // (line 17)
			rd_o_out = local_rd_i; // (line 17)
			local_value_i = value_i_in; // (line 18)
			value_o_out = local_value_i; // (line 18)
			flags_o.write(flags_o_out);
			rd_o.write(rd_o_out);
			value_o.write(value_o_out);
		
			return;
		}
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[0];
	}

	@Override
	public Port[] getInputs() {
		return new Port[] { flags_i, rd_i, value_i };
	}

	public Port getFlags_i() {
		return flags_i;
	}
	public Port getRd_i() {
		return rd_i;
	}
	public Port getValue_i() {
		return value_i;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] { flags_o, rd_o, value_o };
	}

	public Port getFlags_o() {
		return flags_o;
	}
	public Port getRd_o() {
		return rd_o;
	}
	public Port getValue_o() {
		return value_o;
	}

	@Override
	public String toString() {
		return _name;
	}

}
