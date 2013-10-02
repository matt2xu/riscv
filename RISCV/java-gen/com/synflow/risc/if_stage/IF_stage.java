package com.synflow.risc.if_stage;

import java.io.IOException;
import java.math.BigInteger;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;
import com.synflow.risc.if_stage.IF_manage_PC;
import com.synflow.risc.test.DivBy4;
import com.synflow.rom.ROM;

@SuppressWarnings("all")
final public class IF_stage implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(IF_stage.class, args).run();
	}

	private final String _name;

	// ports
	private Port pc_jump;

	private final IF_manage_PC manage_PC;
	private final DivBy4 divby4;
	private final ROM rom_instr;

	/**
	 * constructor
	 */
	public IF_stage(String name, int _flags) {
		this._name = name;

		// create input ports
		pc_jump = new Port(this, "pc_jump", 32, Port.SYNC | _flags);

		// create instances
		manage_PC = new IF_manage_PC("manage_PC", _flags);
		divby4 = new DivBy4("divby4", _flags);
		rom_instr = new ROM("rom_instr", _flags, 0x20, new int[] {0x8001413, 0x10002013, 0x13, 0x13, 0x13, 0x18440033});
	}

	@Override
	public void commit() {
		manage_PC.commit();
		rom_instr.commit();
		
		divby4.execute();
		divby4.commit();
	}

	@Override
	public void connect(Port... ports) {
		this.pc_jump = ports[0];

		manage_PC.connect(manage_PC.getNext_pc(), pc_jump);
		divby4.connect(manage_PC.getPc());
		rom_instr.connect(divby4.getAddr());
	}

	@Override
	public void execute() {
		manage_PC.execute();
		rom_instr.execute();
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[] { manage_PC, divby4, rom_instr };
	}

	@Override
	public Port[] getInputs() {
		return new Port[] { pc_jump };
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] { manage_PC.getNext_pc(), rom_instr.getQ() };
	}

	public Port getPc() {
		return manage_PC.getNext_pc();
	}
	public Port getInstr() {
		return rom_instr.getQ();
	}

	@Override
	public String toString() {
		return _name;
	}

}
