package com.demo;

import java.util.ArrayList;

public class SymmetricGroup {
	public ArrayList<Permutation> elements;
  
	public SymmetricGroup(int n) {
		ArrayList<Permutation> elements = new ArrayList<Permutation>();
		ArrayList<ArrayList<Integer>> tmp = SymmetricGroup.rec(getArrOfIntUnder(n));
		for(int i = 0; i < tmp.size(); i++) {
			Permutation p = new Permutation(tmp.get(i));
			elements.add(p);
		}
		this.elements = elements;
	}

	// 3文字
	// (1)(2,3)
	//   -> (1,2,3)
	//   -> (1,3,2)
	// (2)(1,3)
	//   -> (2,1,3)
	//   -> (2,3,1)
	// (3)(1,2)
	//   -> (3,1,2)
	//   -> (3,2,1)
	public static ArrayList<ArrayList<Integer>> rec(ArrayList<Integer> arr) {
		// System.out.println(arr);
		//want:i=0の時、(1,2,3), (1,3,2)
		if(arr.size() >= 2) {
			ArrayList<ArrayList<Integer>> want = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i < arr.size(); i++) {
				ArrayList<Integer> nokori = new ArrayList<Integer>();
				nokori.addAll(arr);
				//pickupedInt:i=0で1
				Integer pickupedInt = nokori.remove(i);
				//((2,3),(3,2))
				ArrayList<ArrayList<Integer>> todo = rec(nokori);
				for(int j = 0; j < todo.size(); j++) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(pickupedInt);
					tmp.addAll(todo.get(j));
					want.add(tmp);	
				}
			}	
			return want;
		} else {
			ArrayList<ArrayList<Integer>> want = new ArrayList<ArrayList<Integer>>();
			want.add(arr);
			return want;
		}
	}

	private ArrayList<Integer> getArrOfIntUnder(int n) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			arr.add(i);
		}
		return arr;
	}
}