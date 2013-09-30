package com.synflow.risc;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;

@SuppressWarnings("all")
final public class WB_stage implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(WB_stage.class, args).run();
	}

	private final String _name;

	// fields


	// ports
	private Port rd_i;
	private Port flags;
	private Port fromMem;
	private Port fromEx;
	private final Port rd_o;
	private final Port value_o;

	/**
	 * constructor
	 */
	public WB_stage(String name, int _flags) {
		this._name = name;
		rd_i = new Port(this, "rd_i", 5, _flags);
		flags = new Port(this, "flags", 9, _flags);
		fromMem = new Port(this, "fromMem", 32, _flags);
		fromEx = new Port(this, "fromEx", 32, _flags);
		rd_o = new Port(this, "rd_o", 5, _flags);
		value_o = new Port(this, "value_o", 32, _flags);
	}


	@Override
	public void commit() {
		rd_o.commit();
		value_o.commit();
	
	}

	@Override
	public void connect(Port... ports) {
		this.rd_i = ports[0];
		this.flags = ports[1];
		this.fromMem = ports[2];
		this.fromEx = ports[3];

		rd_i.connect();
		flags.connect();
		fromMem.connect();
		fromEx.connect();
	}

	@Override
	public void execute() {
		boolean isSchedulable = false;
		int rd_i_in;
		int flags_in;
		int fromMem_in;
		int fromEx_in;
		int rd_o_out;
		int value_o_out;
	
		if (rd_i.available() && flags.available() && fromMem.available() && fromEx.available()) {
			rd_i_in = rd_i.peekInt(); // (line 16)
			flags_in = flags.peekInt(); // (line 16)
			fromMem_in = fromMem.peekInt(); // (line 16)
			fromEx_in = fromEx.peekInt(); // (line 16)
			isSchedulable = true;
		}
		if (isSchedulable) {
			// action WB_stage_0 (line 16)
			int local_rd_i = 0;
			int flags_i = 0;
			int local_flags = 0;
			int tmp_if = 0;
			int local_fromMem = 0;
			int local_fromEx = 0;
			rd_i_in = rd_i.readInt(); // (line 16)
			flags_in = flags.readInt(); // (line 16)
			fromMem_in = fromMem.readInt(); // (line 16)
			fromEx_in = fromEx.readInt(); // (line 16)
			local_rd_i = rd_i_in; // (line 16)
			rd_o_out = local_rd_i; // (line 16)
			local_flags = flags_in; // (line 17)
			flags_i = local_flags; // (line 0)
			if ((flags_i & 0x1) != 0x0) {
				local_fromMem = fromMem_in; // (line 18)
				tmp_if = local_fromMem; // (line 0)
			} else {
				local_fromEx = fromEx_in; // (line 18)
				tmp_if = local_fromEx; // (line 0)
			}
			value_o_out = tmp_if; // (line 18)
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
		return new Port[] { rd_i, flags, fromMem, fromEx };
	}

	public Port getRd_i() {
		return rd_i;
	}
	public Port getFlags() {
		return flags;
	}
	public Port getFromMem() {
		return fromMem;
	}
	public Port getFromEx() {
		return fromEx;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] { rd_o, value_o };
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
