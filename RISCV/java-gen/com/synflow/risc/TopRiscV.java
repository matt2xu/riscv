package com.synflow.risc;

import java.io.IOException;
import java.math.BigInteger;

import com.synflow.runtime.Entity;
import com.synflow.runtime.Port;
import com.synflow.runtime.Runner;
import com.synflow.risc.FirstJump;
import com.synflow.risc.if_stage.IF_stage;
import com.synflow.risc.id_stage.ID_stage;
import com.synflow.risc.EX_stage;
import com.synflow.risc.mem_stage.MEM_stage;
import com.synflow.risc.WB_stage;

@SuppressWarnings("all")
final public class TopRiscV implements Entity {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		new Runner(TopRiscV.class, args).run();
	}

	private final String _name;

	// ports

	private final FirstJump firstjump;
	private final IF_stage IF_stage;
	private final ID_stage ID_stage;
	private final EX_stage EX_stage;
	private final MEM_stage MEM_stage;
	private final WB_stage WB_stage;

	/**
	 * constructor
	 */
	public TopRiscV(String name, int _flags) {
		this._name = name;

		// create input ports

		// create instances
		firstjump = new FirstJump("firstjump", _flags);
		IF_stage = new IF_stage("IF_stage", _flags);
		ID_stage = new ID_stage("ID_stage", _flags);
		EX_stage = new EX_stage("EX_stage", _flags);
		MEM_stage = new MEM_stage("MEM_stage", _flags);
		WB_stage = new WB_stage("WB_stage", _flags);
	}

	@Override
	public void commit() {
		firstjump.commit();
		IF_stage.commit();
		ID_stage.commit();
		EX_stage.commit();
		MEM_stage.commit();
		
		WB_stage.execute();
		WB_stage.commit();
	}

	@Override
	public void connect(Port... ports) {

		firstjump.connect();
		IF_stage.connect(firstjump.getPc());
		ID_stage.connect(IF_stage.getInstr(), WB_stage.getRd_o(), WB_stage.getValue_o());
		EX_stage.connect(ID_stage.getVal1(), ID_stage.getVal2(), ID_stage.getRd(), ID_stage.getFlags(), ID_stage.getImm());
		MEM_stage.connect(EX_stage.getAddr(), EX_stage.getValue(), EX_stage.getRd_o(), EX_stage.getFlags_o());
		WB_stage.connect(MEM_stage.getRd_o(), MEM_stage.getFlags_o(), MEM_stage.getFromMem(), MEM_stage.getFromEx());
	}

	@Override
	public void execute() {
		firstjump.execute();
		IF_stage.execute();
		ID_stage.execute();
		EX_stage.execute();
		MEM_stage.execute();
	}

	@Override
	public Entity[] getChildren() {
		return new Entity[] { firstjump, IF_stage, ID_stage, EX_stage, MEM_stage, WB_stage };
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
