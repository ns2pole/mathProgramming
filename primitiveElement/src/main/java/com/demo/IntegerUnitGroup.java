package com.demo;
import java.util.LinkedHashSet;
import java.util.ArrayList;

public class IntegerUnitGroup extends Group<Integer> {
	LinkedHashSet<IntegerUnitGroupElement> integerUnitGroupElements;

	public IntegerUnitGroup(LinkedHashSet<IntegerUnitGroupElement> integerUnitGroupElements, Graph<Integer> graph) {
		this.integerUnitGroupElements = integerUnitGroupElements;
		this.graph = graph;
	}

	public static Graph<Integer> getGraphOfUnitGroupFor(int modInt) {
		LinkedHashSet<Map<Integer>> maps = new LinkedHashSet<Map<Integer>>();
		LinkedHashSet<IntegerUnitGroupElement> elements = IntegerUnitGroup.getElementsOfReplicativeGroup(modInt);
		ArrayList<IntegerUnitGroupElement> elementList = new ArrayList<IntegerUnitGroupElement>(elements);
		for(int i = 0; i < elementList.size(); i++) {
			for(int j = 0; j < elementList.size(); j++) {
				Integer remainder = (elementList.get(i).val * elementList.get(j).val) % modInt;
				IntegerUnitGroupElement remainderElement = new IntegerUnitGroupElement(remainder);
				maps.add(new Map<Integer>(elementList.get(i), elementList.get(j), remainderElement));
			}	
		}
		return new Graph<Integer>(maps);
	}
		
	public static LinkedHashSet<IntegerUnitGroupElement> getElementsOfReplicativeGroup(int modInt) {	
		LinkedHashSet<IntegerUnitGroupElement> elements = new LinkedHashSet<IntegerUnitGroupElement>();
		ArrayList<Integer> integers = getCoprimeNumsLowerThan(modInt);
		for(int i = 0; i < integers.size(); i++) {
			elements.add(new IntegerUnitGroupElement(integers.get(i)));
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
		ArrayList<Integer> nums = IntegerUnitGroup.getNaturalNumsLowerThan(integer);
		for(int k = 2; k <= integer;k++) {
			if(integer % k == 0) {
				nums = IntegerUnitGroup.getSievedNumsFor(k, nums);
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

	@Override
	public IntegerUnitGroupElement getElementHas(Integer val) {
		ArrayList<IntegerUnitGroupElement> elementList = new ArrayList<IntegerUnitGroupElement>(this.integerUnitGroupElements);
		for(int i = 0; i < elementList.size(); i++) {
			if(val.equals(elementList.get(i).val)) {
				return elementList.get(i);
			}
		}
		return new IntegerUnitGroupElement(null);
	}
}