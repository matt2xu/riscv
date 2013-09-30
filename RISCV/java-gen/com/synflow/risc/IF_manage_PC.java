package com.synflow.risc;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;

@SuppressWarnings("all")
final public class IF_manage_PC implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(IF_manage_PC.class, args).run();
	}

	private final String _name;

	// fields


	// ports
	private Port pc_normal;
	private Port pc_jump;
	private final Port next_pc;
	private final Port pc;

	/**
	 * constructor
	 */
	public IF_manage_PC(String name, int _flags) {
		this._name = name;
		pc_normal = new Port(this, "pc_normal", 32, _flags);
		pc_jump = new Port(this, "pc_jump", 32, Port.SYNC | _flags);
		next_pc = new Port(this, "next_pc", 32, _flags);
		pc = new Port(this, "pc", 2, _flags);
	}


	@Override
	public void commit() {
		next_pc.commit();
		pc.commit();
	
	}

	@Override
	public void connect(Port... ports) {
		this.pc_normal = ports[0];
		this.pc_jump = ports[1];

		pc_normal.connect();
		pc_jump.connect();
	}

	@Override
	public void execute() {
		boolean isSchedulable = false;
		int pc_normal_in;
		int pc_jump_in;
		int next_pc_out;
		int pc_out;
	
		if (pc_jump.available()) {
			pc_jump_in = pc_jump.peekInt(); // (line 10)
			isSchedulable = true;
		}
		if (isSchedulable) {
			// action IF_manage_PC_0_a (line 10)
			int new_pc = 0;
			int local_pc_jump = 0;
			pc_jump_in = pc_jump.readInt(); // (line 10)
			local_pc_jump = pc_jump_in; // (line 12)
			new_pc = local_pc_jump; // (line 0)
			pc_out = ((new_pc) & 0x3); // (line 20)
			next_pc_out = ((int) ((((long) (new_pc)) & 0xffffffffL) + 0x4L) & 0xffffffff); // (line 21)
			pc.write(pc_out);
			next_pc.write(next_pc_out);
		
			return;
		}
		if (pc_normal.available()) {
			pc_normal_in = pc_normal.peekInt(); // (line 0)
			isSchedulable = true;
		}
		if (isSchedulable) {
			// action IF_manage_PC_0_b (line 0)
			int new_pc = 0;
			int local_pc_normal = 0;
			pc_normal_in = pc_normal.readInt(); // (line 0)
			local_pc_normal = pc_normal_in; // (line 15)
			new_pc = local_pc_normal; // (line 0)
			pc_out = ((new_pc) & 0x3); // (line 20)
			next_pc_out = ((int) ((((long) (new_pc)) & 0xffffffffL) + 0x4L) & 0xffffffff); // (line 21)
			pc.write(pc_out);
			next_pc.write(next_pc_out);
		
			return;
		}
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[0];
	}

	@Override
	public Port[] getInputs() {
		return new Port[] { pc_normal, pc_jump };
	}

	public Port getPc_normal() {
		return pc_normal;
	}
	public Port getPc_jump() {
		return pc_jump;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] { next_pc, pc };
	}

	public Port getNext_pc() {
		return next_pc;
	}
	public Port getPc() {
		return pc;
	}

	@Override
	public String toString() {
		return _name;
	}

}
