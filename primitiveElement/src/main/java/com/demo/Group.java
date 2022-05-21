package com.demo;
import java.util.LinkedHashSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Group<G> {
	BinaryOperator<G> op;
	G unit;
	Function<G, G> getInverseFn;

	Group(BinaryOperator<G> op, G unit, Function<G, G> getInverseFn) {
		this.op = op;
		this.unit = unit;
		this.getInverseFn = getInverseFn;
	}
}