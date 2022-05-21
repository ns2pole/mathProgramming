package com.demo;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class ModInteger extends GroupElement<Integer> {
	public ModInteger(Integer val) {
		super(val);
	}
	
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


	public static Graph<ModInteger> getGraphOfUnitGroupFor(int modInt) {
		LinkedHashSet<Map<ModInteger>> maps = new LinkedHashSet<Map<ModInteger>>();
		LinkedHashSet<ModInteger> elements = getElementsOfReplicativeGroup(modInt);
		ArrayList<ModInteger> elementList = new ArrayList<ModInteger>(elements);
		for(int i = 0; i < elementList.size(); i++) {
			for(int j = 0; j < elementList.size(); j++) {
				ModInteger remainder = new ModInteger((elementList.get(i).val * elementList.get(j).val) % modInt);
				maps.add(new Map<ModInteger>(elementList.get(i), elementList.get(j), remainder));
			}	
		}
		return new Graph<ModInteger>(maps);
	}
		
	public static LinkedHashSet<ModInteger> getElementsOfReplicativeGroup(int modInt) {	
		LinkedHashSet<ModInteger> elements = new LinkedHashSet<ModInteger>();
		ArrayList<Integer> integers = getCoprimeNumsLowerThan(modInt);
		for(int i = 0; i < integers.size(); i++) {
			elements.add(new ModInteger(integers.get(i)));
		}		
		return elements;
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

	public boolean equals(Object modInteger) {
		ModInteger m = (ModInteger) modInteger; 
		return (this.val == m.val);
	}

	public String toString() {
		return String.format("[%d]", this.val);
	}

}