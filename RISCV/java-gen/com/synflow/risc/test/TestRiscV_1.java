package com.synflow.risc.test;

import java.io.IOException;
import java.math.BigInteger;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;
import com.synflow.risc.TopRiscV;
import com.synflow.rom.ROM;
import com.synflow.risc.test.DivBy4;

@SuppressWarnings("all")
final public class TestRiscV_1 implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(TestRiscV_1.class, args).run();
	}

	private final String _name;

	// ports

	private final TopRiscV topriscv;
	private final ROM rom;
	private final DivBy4 divby4;

	/**
	 * constructor
	 */
	public TestRiscV_1(String name, int _flags) {
		this._name = name;

		// create input ports

		// create instances
		topriscv = new TopRiscV("topriscv", _flags);
		rom = new ROM("rom", _flags, 0x20, new int[] {0x8001413, 0x10002013, 0x13, 0x13, 0x13, 0x18440033});
		divby4 = new DivBy4("divby4", _flags);
	}

	@Override
	public void commit() {
		topriscv.commit();
		rom.commit();
		
		divby4.execute();
		divby4.commit();
	}

	@Override
	public void connect(Port... ports) {

		topriscv.connect();
		rom.connect(divby4.getAddr());
		divby4.connect(rom.getQ());
	}

	@Override
	public void execute() {
		topriscv.execute();
		rom.execute();
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[] { topriscv, rom, divby4 };
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
		return new Port[] {  };
	}


	@Override
	public String toString() {
		return _name;
	}

}
