package com.synflow.risc.test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;

@SuppressWarnings("all")
final public class DivBy4 implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(DivBy4.class, args).run();
	}

	private final String _name;

	// fields


	// ports
	private Port pc;
	private final Port addr;

	/**
	 * constructor
	 */
	public DivBy4(String name, int _flags) {
		this._name = name;
		pc = new Port(this, "pc", 32, _flags);
		addr = new Port(this, "addr", 3, _flags);
	}


	@Override
	public void commit() {
		addr.commit();
	
	}

	@Override
	public void connect(Port... ports) {
		this.pc = ports[0];

		pc.connect();
	}

	@Override
	public void execute() {
		boolean isSchedulable = false;
		int pc_in;
		int addr_out;
	
		if (pc.available()) {
			pc_in = pc.peekInt(); // (line 16)
			isSchedulable = true;
		}
		if (isSchedulable) {
			// action DivBy4_0 (line 16)
			int local_pc = 0;
			pc_in = pc.readInt(); // (line 16)
			local_pc = pc_in; // (line 16)
			addr_out = (((local_pc >>> 0x2) & 0x7)); // (line 16)
			addr.write(addr_out);
		
			return;
		}
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[0];
	}

	@Override
	public Port[] getInputs() {
		return new Port[] { pc };
	}

	public Port getPc() {
		return pc;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] { addr };
	}

	public Port getAddr() {
		return addr;
	}

	@Override
	public String toString() {
		return _name;
	}

}
