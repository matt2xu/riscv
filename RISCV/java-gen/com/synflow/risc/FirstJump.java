package com.synflow.risc;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;

@SuppressWarnings("all")
final public class FirstJump implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(FirstJump.class, args).run();
	}

	private final String _name;

	// fields


	// ports
	private final Port pc;

	/**
	 * constructor
	 */
	public FirstJump(String name, int _flags) {
		this._name = name;
		pc = new Port(this, "pc", 32, Port.SYNC | _flags);
	}


	@Override
	public void commit() {
		pc.commit();
	
	}

	@Override
	public void connect(Port... ports) {

	}

	@Override
	public void execute() {
		boolean isSchedulable = false;
		int pc_out;
	
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[0];
	}

	@Override
	public Port[] getInputs() {
		return new Port[] {  };
	}


	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] { pc };
	}

	public Port getPc() {
		return pc;
	}

	@Override
	public String toString() {
		return _name;
	}

}
