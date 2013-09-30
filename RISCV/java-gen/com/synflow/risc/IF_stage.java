package com.synflow.risc;

import java.io.IOException;
import java.math.BigInteger;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;
import com.synflow.risc.IF_manage_PC;
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
		rom_instr = new ROM("rom_instr", _flags, 0x20, new int[] {0x82aa813, 0x1000a813, 0x18002813, 0x20001413});
	}

	@Override
	public void commit() {
		manage_PC.commit();
		rom_instr.commit();
		
	}

	@Override
	public void connect(Port... ports) {
		this.pc_jump = ports[0];

		manage_PC.connect(manage_PC.getNext_pc(), pc_jump);
		rom_instr.connect(manage_PC.getPc());
	}

	@Override
	public void execute() {
		manage_PC.execute();
		rom_instr.execute();
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[] { manage_PC, rom_instr };
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
