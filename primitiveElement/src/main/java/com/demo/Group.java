package com.demo;
import java.util.LinkedHashSet;
import java.util.function.Function;

public class Group<G> {
	LinkedHashSet<G> elements;
	Graph<G> op;
	G unit;
	Function<G, G> getInverseFn;

	// Group(LinkedHashSet<G> elements, BinaryOperator<G> op, G unit, Function<G, G> getInverseFn) {
	// 	this.elements = elements;
	// 	this.op = op;
	// 	this.unit = unit;
	// 	this.getInverseFn = getInverseFn;
	// }
	
}