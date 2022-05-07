package com.demo;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Group<T> extends Set<T> {
	private LinkedHashSet<GroupElement<T>> groupElements;
	Graph<T> graph;

	//TODO:重複しているがうまく継承できず綺麗な書き方が不明。
	@Override
	public GroupElement<T> getElementHas(T val) {
		ArrayList<GroupElement<T>> elementList = new ArrayList<GroupElement<T>>(this.groupElements);
		for(int i = 0; i < elementList.size(); i++) {
			if(val.equals(elementList.get(i).val)) {
				return elementList.get(i);
			}
		}
		return new GroupElement<T>(null);
	}

}