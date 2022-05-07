package com.demo;
import java.util.LinkedHashSet;

public class Graph<T> {
	LinkedHashSet<Map<T>> maps;
	
	public Graph(LinkedHashSet<Map<T>> maps) {
		this.maps = maps;
	}
}