package com.demo;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.function.Function;

public class IrreducibleCosetsGroup extends Group<ModInteger>{
	int modulo;
	public IrreducibleCosetsGroup(int modulo, LinkedHashSet<ModInteger> elements, BinaryOperator<ModInteger> op, ModInteger unit) {
//	public IrreducibleCosetsGroup(int modulo, LinkedHashSet<ModInteger> elements, BinaryOperator<ModInteger> op, ModInteger unit, Function<ModInteger, ModInteger> getInverseFn) {
		super(elements, op, unit);
		this.modulo = modulo;
	}

	public static Graph<ModInteger> getGraphOfIrreducibleCosetsGroupFor(int modInt) {
		LinkedHashSet<Map<ModInteger>> maps = new LinkedHashSet<Map<ModInteger>>();
		LinkedHashSet<ModInteger> elements = getElementsOfIrreducibleCosetsGroup(modInt);
		ArrayList<ModInteger> elementList = new ArrayList<ModInteger>(elements);
		for(int i = 0; i < elementList.size(); i++) {
			for(int j = 0; j < elementList.size(); j++) {
				ModInteger remainder = new ModInteger(modInt, (elementList.get(i).val * elementList.get(j).val) % modInt);
				maps.add(new Map<ModInteger>(elementList.get(i), elementList.get(j), remainder));
			}
		}
		return new Graph<ModInteger>(maps);
	}

	public static LinkedHashSet<ModInteger> getElementsOfIrreducibleCosetsGroup(Integer modulo) {
		LinkedHashSet<ModInteger> elements = new LinkedHashSet<ModInteger>();
		ArrayList<Integer> integers = ModInteger.getCoprimeNumsLowerThan(modulo);
		for(int i = 0; i < integers.size(); i++) {
			elements.add(new ModInteger(modulo, integers.get(i)));
		}
		return elements;
	}

	public static IrreducibleCosetsGroup getIrreducibleCosetsGroup(Integer modulo) {
		LinkedHashSet<ModInteger> elements = getElementsOfIrreducibleCosetsGroup(modulo);
		BinaryOperator<ModInteger> bo = getGraphOfIrreducibleCosetsGroupFor(modulo);
		ModInteger unit = new ModInteger(modulo, 1);
		return new IrreducibleCosetsGroup(modulo, elements, bo, unit);
	}

	public boolean equals(Object o) {
		IrreducibleCosetsGroup g = (IrreducibleCosetsGroup) o;
		return g.modulo == this.modulo && this.unit.equals(g.unit) && this.elements.equals(g.elements);
	}

}