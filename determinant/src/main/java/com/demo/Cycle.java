package com.demo;
import java.util.ArrayList;

//TODO:Cycle->CyclePermutation
public class Cycle {
	//ex.(0123) 0->1 1->2,2->3,3->1
	public ArrayList<Integer> val;
	public Cycle() {
		this.val = new ArrayList<>();
	}

	//(2,4,5)->((2,4)(4,5))
	//(0,1,2,3)->((0,1),(1,2),(2,3))
	//(23)を(2)に作用->3
	//(2,4)(4,5)を(2)に作用->(2,4,5){2}=(2,4)(4,5){2} = (2,4){2} = 4
	//(2,4)(4,5)を(4)に作用->(2,4,5){4}=(2,4)(4,5){4} = (2,4){5} = 5
	//(2,4)(4,5)を(5)に作用->(2,4,5){5}=(2,4)(4,5){5} = (2,4){4} = 2
	public ArrayList<TransPosition> transPositions() {
		ArrayList<TransPosition> trs = new ArrayList<TransPosition>();
		for(int i = 0;i < this.val.size() - 1;i++) {
			TransPosition tr = new TransPosition(val.get(i), val.get(i + 1));
			trs.add(tr);
		}
		return trs;
	}

	// TODO:「同サイクル」(145)と(451)と(514)の定義

	public Cycle getSlideCycle(int slideQuantity) {
		Cycle c = new Cycle();		
		for(int i = slideQuantity; i < this.val.size(); i++) {
			c.val.add(this.val.get(i));
		}
		for(int i = 0; i < slideQuantity; i++) {
			c.val.add(this.val.get(i));
		}
		return c;
	}

	public boolean isSame(Cycle c) {
		for(int i = 0; i < c.val.size(); i++) {
			if(Cycle.isSame(c.getSlideCycle(i).val, c.val)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isSame(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		boolean bool = true;
		for(int j = 0; j < arr1.size(); j++) {
			if(arr1.get(j) != arr2.get(j)) {
				return false;
			}
		}
		return bool;
	}

	public boolean existSameCycleIn(ArrayList<Cycle> cycles) {
		for(int i = 0; i < cycles.size(); i++){
			if(this.isSame(cycles.get(i))) {
				return true;
			}
		}
		return false;
	}


	public static ArrayList<Cycle> getNoDuplicateCycles(ArrayList<Cycle> cycles) {
		ArrayList<Cycle> noDuplicateCycles = new ArrayList<>();
		for(int i = 0; i < cycles.size(); i++){
			if(!cycles.get(i).existSameCycleIn(noDuplicateCycles)) {
				noDuplicateCycles.add(cycles.get(i));
			}
		}
		return noDuplicateCycles;
	}


}