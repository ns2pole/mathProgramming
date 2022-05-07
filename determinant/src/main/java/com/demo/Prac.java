package com.demo;

import java.util.ArrayList;

public class Prac {
	public ArrayList<Permutation> elements;
  

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
		//1. arr->(3,4)
		if(arr.size() >= 2) {
			ArrayList<ArrayList<Integer>> want = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i < arr.size(); i++) {
				ArrayList<Integer> nokori = new ArrayList<Integer>();
				nokori.addAll(arr);
				//2.pickupedInt:i=0で3
				Integer pickupedInt = nokori.remove(i);
				ArrayList<ArrayList<Integer>> todo = rec(nokori);
				for(int j = 0; j < todo.size(); j++) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
                //5. pickupedInt->((3))
					tmp.add(pickupedInt);
                //6. tmp->((3,4))
					tmp.addAll(todo.get(j));
					want.add(tmp);	
				}
			}	
			return want;
		} else {
		//3. arr->(4)
			ArrayList<ArrayList<Integer>> want = new ArrayList<ArrayList<Integer>>();
			want.add(arr);
        //4. return want->((4))
			return want;
		}
	}

}