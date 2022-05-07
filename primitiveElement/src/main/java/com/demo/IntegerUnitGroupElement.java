package com.demo;
import java.util.ArrayList;

public class IntegerUnitGroupElement extends GroupElement<Integer>{
	
	public IntegerUnitGroupElement(Integer val) {
		super(val);
	}

	public IntegerUnitGroupElement operateTo(IntegerUnitGroupElement e, Graph<Integer> graph) {
	//群による。G×G→Gのグラフによる。G×G→Gのグラフから作る。
		ArrayList<Map<Integer>> maps = new ArrayList<Map<Integer>>(graph.maps);
		IntegerUnitGroupElement element = new IntegerUnitGroupElement(null);
		for(int i = 0; i < maps.size(); i++) {
			if(maps.get(i).argument1.val.equals(this.val) && maps.get(i).argument2.val.equals(e.val)) {
				element.val = maps.get(i).result.val;
				break;
			}
		}
		return element;
	}

	
}