package com.demo;
import java.util.ArrayList;

public class GroupElement<T> {
	T val;
	Group<T> affiliationGroup;
	public GroupElement(T val) {
		this.val = val;
	}

	public GroupElement<T> getNthPower(Integer n) {
		BinaryOperator<T> bo = this.affiliationGroup.op;
		if(1 < n) {
			T resultVal = bo.calc(this.val, this.getNthPower(n - 1).val);
			GroupElement<T> ge = new GroupElement<T>(resultVal);
			return ge;
		} else {
			return this;
		}
	}
	public String toString() {
		return String.format("%n val -> %s" + "%n group -> %s", this.val, this.affiliationGroup);
	}

	@Override
	public boolean equals(Object o) {
		GroupElement<T> ge = (GroupElement<T>) o;
		return this.val.equals(ge.val) && this.affiliationGroup.elements.equals(ge.affiliationGroup.elements);
	}
}