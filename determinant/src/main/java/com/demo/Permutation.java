package com.demo;

import java.util.ArrayList;

public class Permutation {
	public ArrayList<Integer> val;
	//meaning:(1,3,2,4,0) 0->1 1->3,2->2,3->4,4->0
	public Permutation(ArrayList<Integer> val) {
		this.val = val;
	}

	// (1,3,2,4,0) -> (0134)(2)
	// TODO:一回作ってから削るのが雑。
	public ArrayList<Cycle> cycles() {
		ArrayList<Cycle> cycles = new ArrayList<>();
		for(int i = 0; i < this.val.size(); i++) {
			Cycle c =  this.cycleOf(i);
			cycles.add(c);
		}
		return Cycle.getNoDuplicateCycles(cycles);
	}

	// ex. p->(1,3,2,4,0), i->0 
	// return->(0134)
	// getMappedValOfを3回やって戻ってきた判定をする。その間にcycleを作る。
	public Cycle cycleOf(int i) {
		Cycle c = new Cycle();
		for(int times = 1; times <= this.getCycleLengthOf(i); times++) {
			c.val.add(this.getMappedValRecursivelyFor(i, times));
		}
		return c;
	}

	// ex. p->(4,3,2,5,1), 
	// i->1 
	// return 3
	// i->2
	// return 2
	public int getCycleLengthOf(int i) {
		int cycleLength = 0;
		for(int times = 1; times <= this.val.size(); times++) {
			cycleLength++;
			if(getMappedValRecursivelyFor(i, times) == i) {
				break;
			}
		}
		return cycleLength;
	}

	// 再帰処理
	// ex. p->(4,3,2,5,1), i->4 times->2 4->5->1
	// return 1
	public int getMappedValRecursivelyFor(int i, int times) {
		// System.out.println("times");
		// System.out.println(times);
		if(times == 1) {
			//2回目: getMappedValOf(5)
			return getMappedValOf(i);
		} else {
			//以下、要は1回目: getMappedValRecursivelyFor(5, 1)
			return this.getMappedValRecursivelyFor(getMappedValOf(i), times - 1);
		}
	}

	private int getMappedValOf(int i) {
		// ex. p->(4,3,2,5,1), i->1 
		// return->3
		return this.val.get(i);
	}

	public ArrayList<TransPosition> transPositions() {
		ArrayList<TransPosition> transPositions = new ArrayList<TransPosition>();
		ArrayList<Cycle> arrCycles = this.cycles();
		for(int i = 0; i < arrCycles.size(); i++) {
			transPositions.addAll(arrCycles.get(i).transPositions());
		}		
		return transPositions;
	}

	public Signature signature() {
		if(this.transPositions().size() % 2 == 0) {
			Signature s = new Signature(1);
			return s;
		} else {
			Signature s = new Signature(-1);
			return s;
		}
	}
}