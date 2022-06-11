package com.demo;

import java.util.ArrayList;

public class ModInteger {
	Integer val;
	Integer modulo;
	public ModInteger(Integer modulo, Integer val) {
		this.val = val;
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

	public boolean equals(Object modInteger) {
		ModInteger m = (ModInteger) modInteger;
		return (this.val == m.val && this.modulo == m.modulo);
	}

	public int hashCode() {
		return 0;
	}

	public String toString() {
		return String.format("[%d]", this.val);
	}

}