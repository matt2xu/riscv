package com.synflow.risc.id_stage;

import java.io.IOException;
import java.math.BigInteger;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;
import com.synflow.risc.id_stage.ID_control_rd;
import com.synflow.risc.id_stage.ID_decode_rs;
import com.synflow.risc.id_stage.RegFile;
import com.synflow.risc.id_stage.ID_decode;

@SuppressWarnings("all")
final public class ID_stage implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(ID_stage.class, args).run();
	}

	private final String _name;

	// ports
	private Port instr;
	private Port previous_rd;
	private Port previous_data;

	private final ID_control_rd control_rd;
	private final ID_decode_rs decode_rs;
	private final RegFile regFile;
	private final ID_decode decode;

	/**
	 * constructor
	 */
	public ID_stage(String name, int _flags) {
		this._name = name;

		// create input ports
		instr = new Port(this, "instr", 32, _flags);
		previous_rd = new Port(this, "previous_rd", 5, _flags);
		previous_data = new Port(this, "previous_data", 32, Port.SYNC | _flags);

		// create instances
		control_rd = new ID_control_rd("control_rd", _flags);
		decode_rs = new ID_decode_rs("decode_rs", _flags);
		regFile = new RegFile("regFile", _flags);
		decode = new ID_decode("decode", _flags);
	}

	@Override
	public void commit() {
		regFile.commit();
		decode.commit();
		
		control_rd.execute();
		control_rd.commit();
		decode_rs.execute();
		decode_rs.commit();
	}

	@Override
	public void connect(Port... ports) {
		this.instr = ports[0];
		this.previous_rd = ports[1];
		this.previous_data = ports[2];

		control_rd.connect(previous_rd, previous_data);
		decode_rs.connect(instr);
		regFile.connect(decode_rs.getRs1(), decode_rs.getRs2(), control_rd.getRd_o(), control_rd.getData_o());
		decode.connect(instr);
	}

	@Override
	public void execute() {
		regFile.execute();
		decode.execute();
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[] { control_rd, decode_rs, regFile, decode };
	}

	@Override
	public Port[] getInputs() {
		return new Port[] { instr, previous_rd, previous_data };
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public Port[] getOutputs() {
		return new Port[] { regFile.getOp1(), regFile.getOp2(), decode.getRd(), decode.getFlags(), decode.getFunc(), decode.getImm() };
	}

	public Port getVal1() {
		return regFile.getOp1();
	}
	public Port getVal2() {
		return regFile.getOp2();
	}
	public Port getRd() {
		return decode.getRd();
	}
	public Port getFlags() {
		return decode.getFlags();
	}
	public Port getFunc() {
		return decode.getFunc();
	}
	public Port getImm() {
		return decode.getImm();
	}

	@Override
	public String toString() {
		return _name;
	}

}
