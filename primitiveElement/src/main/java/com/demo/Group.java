package com.demo;
import java.util.LinkedHashSet;
import java.util.function.Function;

public class Group<G> {
	LinkedHashSet<G> elements;
	BinaryOperator<G> op;
	G unit;
	Function<G, G> getInverseFn;

//	public Group(LinkedHashSet<G> elements, BinaryOperator<G> op, G unit, Function<G, G> getInverseFn) {
	 public Group(LinkedHashSet<G> elements, BinaryOperator<G> op, G unit) {
	 	this.elements = elements;
	 	this.op = op;
	 	this.unit = unit;
//	 	this.getInverseFn = getInverseFn;
	 }

	 public Integer getOrder() {
		 return this.elements.size();
	 }

	public String toString() {
		return String.format("%s", this.op);
	}


	public boolean equals(Object o) {
		Group<G> g = (Group<G>) o;
		return g.elements.equals(this.elements);
	}

	public int hashCode() {
		return this.elements.hashCode();
	}
// 	public Group<G> generateCyclicGroup() {
// 		LinkedHashSet<G> cyclicGroup = new LinkedHashSet<ModInteger>();
// 		BinaryOperator<G> bo = getGraphOfIrreducibleCosetsGroupFor(this.modulo);
// //		ModInteger clone = new ModInteger(this.modulo, this.val);
// 		ModInteger m = bo.calc(this, this);
// 	}
}