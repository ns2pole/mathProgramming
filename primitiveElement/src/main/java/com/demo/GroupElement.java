package com.demo;
import java.util.ArrayList;

public class GroupElement<T> extends Element<T>{
	
	public GroupElement(T val) {
		super(val);
	}

	public GroupElement<T> operateTo(GroupElement<T> e, Graph<T> graph) {
	//群による。G×G→Gのグラフによる。G×G→Gのグラフから作る。
		ArrayList<Map<T>> maps = new ArrayList<Map<T>>(graph.maps);
		GroupElement<T> element = new GroupElement<T>(null);
		for(int i = 0; i < maps.size(); i++) {
			if(maps.get(i).argument1.val.equals(this.val) && maps.get(i).argument2.val.equals(e.val)) {
				element.val = maps.get(i).result.val;
				break;
			}
		}
		return element;
	}

	
}