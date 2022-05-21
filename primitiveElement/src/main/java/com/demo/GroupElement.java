package com.demo;
import java.util.ArrayList;

public class GroupElement<T> {
	T val;
	
	public GroupElement(T val) {
		this.val = val;
	}

	public GroupElement<T> operateTo(GroupElement<T> e, Graph<T> graph) {
	//群による。G×G→Gのグラフによる。G×G→Gのグラフから作る。
		ArrayList<Map<T>> maps = new ArrayList<Map<T>>(graph.maps);
		GroupElement<T> element = new GroupElement<T>(null);
		System.out.println(graph.maps);
		for(int i = 0; i < maps.size(); i++) {
			if(maps.get(i).argument1.equals(this.val) && maps.get(i).argument2.equals(e.val)) {
				element.val = maps.get(i).result;
				break;
			}
		}
		return element;
	}

	
}