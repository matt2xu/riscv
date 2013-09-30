package com.synflow.risc.id_stage;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;

@SuppressWarnings("all")
final public class ID_control_rd implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(ID_control_rd.class, args).run();
	}

	private final String _name;

	// fields


	// ports
	private Port rd_i;
	private Port data_i;
	private final Port rd_o;
	private final Port data_o;

	/**
	 * constructor
	 */
	public ID_control_rd(String name, int _flags) {
		this._name = name;
		rd_i = new Port(this, "rd_i", 5, _flags);
		data_i = new Port(this, "data_i", 32, Port.SYNC | _flags);
		rd_o = new Port(this, "rd_o", 5, _flags);
		data_o = new Port(this, "data_o", 32, Port.SYNC | _flags);
	}


	@Override
	public void commit() {
		rd_o.commit();
		data_o.commit();
	
	}

	@Override
	public void connect(Port... ports) {
		this.rd_i = ports[0];
		this.data_i = ports[1];

		rd_i.connect();
		data_i.connect();
	}

	@Override
	public void execute() {
		boolean isSchedulable = false;
		int rd_i_in;
		int data_i_in;
		int rd_o_out;
		int data_o_out;
	
		if (rd_i.available() && data_i.available()) {
			int local_rd_i = 0;
			rd_i_in = rd_i.peekInt(); // (line 17)
			data_i_in = data_i.peekInt(); // (line 17)
			local_rd_i = rd_i_in; // (line 17)
			isSchedulable = local_rd_i != 0x0;
		}
		if (isSchedulable) {
			// action ID_control_rd_0_a (line 17)
			int local_rd_i = 0;
			int local_data_i = 0;
			rd_i_in = rd_i.readInt(); // (line 17)
			data_i_in = data_i.readInt(); // (line 17)
			local_rd_i = rd_i_in; // (line 18)
			rd_o_out = local_rd_i; // (line 18)
			local_data_i = data_i_in; // (line 19)
			data_o_out = local_data_i; // (line 19)
			rd_o.write(rd_o_out);
			data_o.write(data_o_out);
		
			return;
		}
		if (rd_i.available()) {
			rd_i_in = rd_i.peekInt(); // (line 0)
			isSchedulable = true;
		}
		if (isSchedulable) {
			// action ID_control_rd_0_b (line 0)
			rd_i_in = rd_i.readInt(); // (line 0)
		
			return;
		}
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[0];
	}

	@Override
	public Port[] getInputs() {
		return new Port[] { rd_i, data_i };
	}

	public Port getRd_i() {
		return rd_i;
	}
	public Port getData_i() {
		return data_i;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] { rd_o, data_o };
	}

	public Port getRd_o() {
		return rd_o;
	}
	public Port getData_o() {
		return data_o;
	}

	@Override
	public String toString() {
		return _name;
	}

}
