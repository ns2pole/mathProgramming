package com.demo;
import java.util.LinkedHashSet;
import java.util.ArrayList;

public class Graph<A> implements BinaryOperator<A> {
	LinkedHashSet<Map<A>> maps;
	
	public Graph(LinkedHashSet<Map<A>> maps) {
		this.maps = maps;
	}

	@Override
	public A calc(A left, A right) {
		ArrayList<Map<A>> mapList = new ArrayList<Map<A>>(this.maps);
		for(int i = 0; i < mapList.size(); i++) {
			if(mapList.get(i).argument1.equals(left) && mapList.get(i).argument2.equals(right)) {
				return mapList.get(i).result;
			}
		}
		throw new RuntimeException();
	}

	public String toString() {
		return this.maps.toString();
	}
}