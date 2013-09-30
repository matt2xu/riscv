package com.synflow.risc.id_stage;

import java.io.IOException;
import java.math.BigInteger;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;
import com.synflow.ram.Dual_Port_RAM;
import com.synflow.ram.Dual_Port_RAM;

@SuppressWarnings("all")
final public class RegFile implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(RegFile.class, args).run();
	}

	private final String _name;

	// ports
	private Port rs1;
	private Port rs2;
	private Port rd;
	private Port data;

	private final Dual_Port_RAM ram_2;
	private final Dual_Port_RAM ram_1;

	/**
	 * constructor
	 */
	public RegFile(String name, int _flags) {
		this._name = name;

		// create input ports
		rs1 = new Port(this, "rs1", 5, _flags);
		rs2 = new Port(this, "rs2", 5, _flags);
		rd = new Port(this, "rd", 5, _flags);
		data = new Port(this, "data", 32, Port.SYNC | _flags);

		// create instances
		ram_2 = new Dual_Port_RAM("ram_2", _flags, 0x5, 0x20);
		ram_1 = new Dual_Port_RAM("ram_1", _flags, 0x5, 0x20);
	}

	@Override
	public void commit() {
		ram_2.commit();
		ram_1.commit();
		
	}

	@Override
	public void connect(Port... ports) {
		this.rs1 = ports[0];
		this.rs2 = ports[1];
		this.rd = ports[2];
		this.data = ports[3];

		ram_2.connect(rs2, rd, data);
		ram_1.connect(rs1, rd, data);
	}

	@Override
	public void execute() {
		ram_2.execute();
		ram_1.execute();
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[] { ram_2, ram_1 };
	}

	@Override
	public Port[] getInputs() {
		return new Port[] { rs1, rs2, rd, data };
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] { ram_1.getQ(), ram_2.getQ() };
	}

	public Port getOp1() {
		return ram_1.getQ();
	}
	public Port getOp2() {
		return ram_2.getQ();
	}

	@Override
	public String toString() {
		return _name;
	}

}
