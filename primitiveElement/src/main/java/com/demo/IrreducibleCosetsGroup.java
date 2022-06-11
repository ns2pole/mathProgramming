package com.demo;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.function.Function;

public class IrreducibleCosetsGroup extends Group<ModInteger>{
	int modulo;
	public IrreducibleCosetsGroup(int modulo, LinkedHashSet<ModInteger> elements, BinaryOperator<ModInteger> op) {
//	public IrreducibleCosetsGroup(int modulo, LinkedHashSet<ModInteger> elements, BinaryOperator<ModInteger> op, ModInteger unit, Function<ModInteger, ModInteger> getInverseFn) {
		super(elements, op);
		this.modulo = modulo;
	}

}