package com.synflow.risc.mem_stage;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;

@SuppressWarnings("all")
final public class MEM_addr_control implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(MEM_addr_control.class, args).run();
	}

	private final String _name;

	// fields
	private int isSchedulable_MEM_addr_control_0_a_addr_o[] = new int[1];
	private Set<Integer> isSchedulable_MEM_addr_control_0_a_addr_o_written = new HashSet<>();


	// ports
	private Port flags;
	private Port addr_i;
	private Port value;
	private final Port addr_o;
	private final Port data;

	/**
	 * constructor
	 */
	public MEM_addr_control(String name, int _flags) {
		this._name = name;
		flags = new Port(this, "flags", 9, _flags);
		addr_i = new Port(this, "addr_i", 32, _flags);
		value = new Port(this, "value", 32, _flags);
		addr_o = new Port(this, "addr_o", 16, _flags);
		data = new Port(this, "data", 32, Port.SYNC | _flags);
	}


	@Override
	public void commit() {
		addr_o.commit();
		data.commit();
	
		if (!isSchedulable_MEM_addr_control_0_a_addr_o_written.isEmpty()) {
			isSchedulable_MEM_addr_control_0_a_addr_o_written.clear();
		}
	}

	@Override
	public void connect(Port... ports) {
		this.flags = ports[0];
		this.addr_i = ports[1];
		this.value = ports[2];

		flags.connect();
		addr_i.connect();
		value.connect();
	}

	@Override
	public void execute() {
		boolean isSchedulable = false;
		int flags_in;
		int addr_i_in;
		int value_in;
		int addr_o_out;
		int data_out;
	
		if (addr_i.available() && flags.available() && value.available()) {
			int local_addr_i = 0;
			int flags_i = 0;
			int local_flags = 0;
			addr_i_in = addr_i.peekInt(); // (line 19)
			flags_in = flags.peekInt(); // (line 19)
			value_in = value.peekInt(); // (line 19)
			local_addr_i = addr_i_in; // (line 16)
			local_flags = flags_in; // (line 17)
			flags_i = local_flags; // (line 0)
			System.out.println(this + ": " + "flags: " + "0x" + Integer.toHexString(flags_i)); // (line 18)
			isSchedulable = (flags_i & 0x2) != 0x0;
		}
		if (isSchedulable) {
			// action MEM_addr_control_0_a (line 19)
			int local_addr_i = 0;
			int flags_i = 0;
			int local_flags = 0;
			int local_value = 0;
			addr_i_in = addr_i.readInt(); // (line 19)
			flags_in = flags.readInt(); // (line 19)
			value_in = value.readInt(); // (line 19)
			local_addr_i = addr_i_in; // (line 16)
			addr_o_out = ((local_addr_i) & 0xffff); // (line 16)
			local_flags = flags_in; // (line 17)
			flags_i = local_flags; // (line 0)
			System.out.println(this + ": " + "flags: " + "0x" + Integer.toHexString(flags_i)); // (line 18)
			local_value = value_in; // (line 20)
			data_out = local_value; // (line 20)
			addr_o.write(addr_o_out);
			data.write(data_out);
		
			return;
		}
		if (addr_i.available() && flags.available()) {
			int local_addr_i = 0;
			int flags_i = 0;
			int local_flags = 0;
			addr_i_in = addr_i.peekInt(); // (line 0)
			flags_in = flags.peekInt(); // (line 0)
			local_addr_i = addr_i_in; // (line 16)
			local_flags = flags_in; // (line 17)
			flags_i = local_flags; // (line 0)
			System.out.println(this + ": " + "flags: " + "0x" + Integer.toHexString(flags_i)); // (line 18)
			isSchedulable = true;
		}
		if (isSchedulable) {
			// action MEM_addr_control_0_b (line 0)
			int local_addr_i = 0;
			int flags_i = 0;
			int local_flags = 0;
			addr_i_in = addr_i.readInt(); // (line 0)
			flags_in = flags.readInt(); // (line 0)
			local_addr_i = addr_i_in; // (line 16)
			addr_o_out = ((local_addr_i) & 0xffff); // (line 16)
			local_flags = flags_in; // (line 17)
			flags_i = local_flags; // (line 0)
			System.out.println(this + ": " + "flags: " + "0x" + Integer.toHexString(flags_i)); // (line 18)
			addr_o.write(addr_o_out);
		
			return;
		}
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[0];
	}

	@Override
	public Port[] getInputs() {
		return new Port[] { flags, addr_i, value };
	}

	public Port getFlags() {
		return flags;
	}
	public Port getAddr_i() {
		return addr_i;
	}
	public Port getValue() {
		return value;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] { addr_o, data };
	}

	public Port getAddr_o() {
		return addr_o;
	}
	public Port getData() {
		return data;
	}

	@Override
	public String toString() {
		return _name;
	}

}
