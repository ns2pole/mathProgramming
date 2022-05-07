package com.demo;
import java.util.ArrayList;

public class IntegerUnitGroupElement extends GroupElement<Integer>{
	
	public IntegerUnitGroupElement(Integer val) {
		super(val);
	}
	
	//TODO:Groupと重複しているがうまく継承できず綺麗な書き方が不明。
	public IntegerUnitGroupElement operateTo(IntegerUnitGroupElement e, Graph<IntegerUnitGroupElement> graph) {
		//群による。G×G→Gのグラフによる。G×G→Gのグラフから作る。
		ArrayList<Map<IntegerUnitGroupElement>> maps = new ArrayList<Map<IntegerUnitGroupElement>>(graph.maps);
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