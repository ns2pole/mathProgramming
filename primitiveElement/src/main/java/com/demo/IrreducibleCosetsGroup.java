package com.demo;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.function.Function;

public class IrreducibleCosetsGroup extends Group<ModInteger>{
	int modulo;
	public IrreducibleCosetsGroup(int modulo) {
		this.modulo = modulo;
		this.op = ModInteger.getGraphOfUnitGroupFor(modulo);

		this.unit = unit;
		this.getInverseFn = getInverseFn;
	}

}