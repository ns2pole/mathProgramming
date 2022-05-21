package com.demo;
import java.util.LinkedHashSet;

public class Graph<G> {
	LinkedHashSet<Map<G>> maps;
	
	public Graph(LinkedHashSet<Map<G>> maps) {
		this.maps = maps;
	}
}