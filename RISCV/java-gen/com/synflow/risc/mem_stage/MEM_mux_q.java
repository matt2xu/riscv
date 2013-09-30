package com.synflow.risc.mem_stage;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;

@SuppressWarnings("all")
final public class MEM_mux_q implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(MEM_mux_q.class, args).run();
	}

	private final String _name;

	// fields


	// ports
	private Port memOp;
	private Port value;
	private final Port data;

	/**
	 * constructor
	 */
	public MEM_mux_q(String name, int _flags) {
		this._name = name;
		memOp = new Port(this, "memOp", 2, _flags);
		value = new Port(this, "value", 32, _flags);
		data = new Port(this, "data", 32, _flags);
	}


	@Override
	public void commit() {
		data.commit();
	
	}

	@Override
	public void connect(Port... ports) {
		this.memOp = ports[0];
		this.value = ports[1];

		memOp.connect();
		value.connect();
	}

	@Override
	public void execute() {
		boolean isSchedulable = false;
		int memOp_in;
		int value_in;
		int data_out;
	
		if (memOp.available() && value.available()) {
			int ops = 0;
			int local_memOp = 0;
			memOp_in = memOp.peekInt(); // (line 17)
			value_in = value.peekInt(); // (line 17)
			local_memOp = memOp_in; // (line 16)
			ops = local_memOp; // (line 0)
			isSchedulable = (ops & 0x1) != 0x0;
		}
		if (isSchedulable) {
			// action MEM_mux_q_0_a (line 17)
			int ops = 0;
			int local_memOp = 0;
			int local_value = 0;
			memOp_in = memOp.readInt(); // (line 17)
			value_in = value.readInt(); // (line 17)
			local_memOp = memOp_in; // (line 16)
			ops = local_memOp; // (line 0)
			local_value = value_in; // (line 18)
			data_out = local_value; // (line 18)
			data.write(data_out);
		
			return;
		}
		if (memOp.available()) {
			int ops = 0;
			int local_memOp = 0;
			memOp_in = memOp.peekInt(); // (line 0)
			local_memOp = memOp_in; // (line 16)
			ops = local_memOp; // (line 0)
			isSchedulable = true;
		}
		if (isSchedulable) {
			// action MEM_mux_q_0_b (line 0)
			int ops = 0;
			int local_memOp = 0;
			memOp_in = memOp.readInt(); // (line 0)
			local_memOp = memOp_in; // (line 16)
			ops = local_memOp; // (line 0)
		
			return;
		}
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[0];
	}

	@Override
	public Port[] getInputs() {
		return new Port[] { memOp, value };
	}

	public Port getMemOp() {
		return memOp;
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
		return new Port[] { data };
	}

	public Port getData() {
		return data;
	}

	@Override
	public String toString() {
		return _name;
	}

}
