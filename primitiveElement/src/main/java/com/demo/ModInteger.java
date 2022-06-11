package com.demo;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class ModInteger extends GroupElement<Integer> {
	Integer modulo;
	public ModInteger(Integer modulo, Integer val) {
		super(val);
		this.modulo = modulo;
	}
	// public Group<G> generateGroup() {
	// 	this.op
	// }
	
	// //TODO:Groupと重複しているがうまく継承できず綺麗な書き方が不明。
	// public ModInteger operateTo(ModInteger e, Graph<ModInteger> graph) {
	// 	//群による。G×G→Gのグラフによる。G×G→Gのグラフから作る。
	// 	ArrayList<Map<ModInteger>> maps = new ArrayList<Map<ModInteger>>(graph.maps);
	// 	ModInteger element = new ModInteger(null);
	// 	for(int i = 0; i < maps.size(); i++) {
	// 		if(maps.get(i).argument1.val.equals(this.val) && maps.get(i).argument2.val.equals(e.val)) {
	// 			element.val = maps.get(i).result.val;
	// 			break;
	// 		}
	// 	}
	// 	return element;
	// }


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
		ArrayList<Integer> integers = getCoprimeNumsLowerThan(modulo);
		for(int i = 0; i < integers.size(); i++) {
			elements.add(new ModInteger(modulo, integers.get(i)));
		}		
		return elements;
	}

	public static int getEulerPhiFunctionValOf(int integer) {
        return getCoprimeNumsLowerThan(integer).size();
    }

	public static IrreducibleCosetsGroup getIrreducibleCosetsGroup(Integer modulo) {
		LinkedHashSet<ModInteger> elements = getElementsOfIrreducibleCosetsGroup(modulo);
		BinaryOperator<ModInteger> bo = getGraphOfIrreducibleCosetsGroupFor(modulo);
		return new IrreducibleCosetsGroup(modulo, elements, bo);
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

	//TODO:単位元を使って書き直す
	public Integer getOrder() {
		Integer order = 2;
		while (!this.getNthPower(order).equals(this.getNthPower(1))) {
//		while (this.getNthPower(order).equals(this.irreducibleCosetsGroup().unit)) {
			order++;
		}
		return order - 1;
//		return order;
	}

	//TODO:n<=0の場合
	public ModInteger getNthPower(Integer n) {
		BinaryOperator<ModInteger> bo = getGraphOfIrreducibleCosetsGroupFor(this.modulo);
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