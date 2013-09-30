package com.synflow.risc.mem_stage;

import java.io.IOException;
import java.math.BigInteger;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;
import com.synflow.risc.mem_stage.MEM_forward;
import com.synflow.risc.mem_stage.MEM_addr_control;
import com.synflow.ram.Single_Port_RAM;

@SuppressWarnings("all")
final public class MEM_stage implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(MEM_stage.class, args).run();
	}

	private final String _name;

	// ports
	private Port addr;
	private Port value;
	private Port rd_i;
	private Port flags_i;

	private final MEM_forward mem_forward;
	private final MEM_addr_control addr_control;
	private final Single_Port_RAM ram;

	/**
	 * constructor
	 */
	public MEM_stage(String name, int _flags) {
		this._name = name;

		// create input ports
		addr = new Port(this, "addr", 32, _flags);
		value = new Port(this, "value", 32, _flags);
		rd_i = new Port(this, "rd_i", 5, _flags);
		flags_i = new Port(this, "flags_i", 9, _flags);

		// create instances
		mem_forward = new MEM_forward("mem_forward", _flags);
		addr_control = new MEM_addr_control("addr_control", _flags);
		ram = new Single_Port_RAM("ram", _flags, 0x10, 0x20);
	}

	@Override
	public void commit() {
		mem_forward.commit();
		ram.commit();
		
		addr_control.execute();
		addr_control.commit();
	}

	@Override
	public void connect(Port... ports) {
		this.addr = ports[0];
		this.value = ports[1];
		this.rd_i = ports[2];
		this.flags_i = ports[3];

		mem_forward.connect(flags_i, rd_i, value);
		addr_control.connect(flags_i, addr, value);
		ram.connect(addr_control.getAddr_o(), addr_control.getData());
	}

	@Override
	public void execute() {
		mem_forward.execute();
		ram.execute();
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[] { mem_forward, addr_control, ram };
	}

	@Override
	public Port[] getInputs() {
		return new Port[] { addr, value, rd_i, flags_i };
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] { mem_forward.getRd_o(), mem_forward.getFlags_o(), ram.getQ(), mem_forward.getValue_o() };
	}

	public Port getRd_o() {
		return mem_forward.getRd_o();
	}
	public Port getFlags_o() {
		return mem_forward.getFlags_o();
	}
	public Port getFromMem() {
		return ram.getQ();
	}
	public Port getFromEx() {
		return mem_forward.getValue_o();
	}

	@Override
	public String toString() {
		return _name;
	}

}
