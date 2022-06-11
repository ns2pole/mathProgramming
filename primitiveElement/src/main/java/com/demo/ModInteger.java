package com.demo;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class ModInteger extends GroupElement<Integer> {
	Integer modulo;
	public ModInteger(Integer modulo, Integer val) {
		super(val);
		this.modulo = modulo;
	}

	public static ArrayList<Integer> getSievedNumsFor(int sieve, ArrayList<Integer> nums) {
		for(int i = 0; i < nums.size(); i++) {
			if(nums.get(i).intValue() % sieve == 0) {
				nums.remove(i);
				i--;
			}
		}
		return nums;
	}
	public static ArrayList<Integer> getCoprimeNumsLowerThan(int integer) {
		ArrayList<Integer> nums = getNaturalNumsLowerThan(integer);
		for(int k = 2; k <= integer;k++) {
			if(integer % k == 0) {
				nums = getSievedNumsFor(k, nums);
			}
		}
		return nums;
	}

	//TODO:stream使う
	public static ArrayList<Integer> getNaturalNumsLowerThan(int integer) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int k = 1; k <= integer;k++) {
            arr.add(k);
        }
        return arr;
    }

//	public Group<ModInteger> generateCyclicGroup() {
//		LinkedHashSet<ModInteger> cyclicGroup = new LinkedHashSet<ModInteger>();
//		BinaryOperator<ModInteger> bo = getGraphOfIrreducibleCosetsGroupFor(this.modulo);
////		ModInteger clone = new ModInteger(this.modulo, this.val);
//		ModInteger m = bo.calc(this, this);
//	}

	public Integer getOrder() {
		Integer order = 2;
		ModInteger unit = new ModInteger(this.modulo, 1);
		while (!this.getNthPower(order).equals(unit)) {
			order++;
		}
		return order;
	}

	//TODO:n<=0の場合
	public ModInteger getNthPower(Integer n) {
		BinaryOperator<ModInteger> bo = IrreducibleCosetsGroup.getGraphOfIrreducibleCosetsGroupFor(this.modulo);
		if(1 < n) {
			return bo.calc(this, this.getNthPower(n - 1));
		} else {
			return this;
		}
	}

	public boolean equals(Object modInteger) {
		ModInteger m = (ModInteger) modInteger;
		return (this.val == m.val && this.modulo == m.modulo);
	}

	public String toString() {
		return String.format("[%d]", this.val);
	}

}