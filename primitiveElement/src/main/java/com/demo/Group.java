package com.demo;
import java.util.LinkedHashSet;

public class Group<T> {
	LinkedHashSet<T> groupElements;
	Graph<T> graph;

	Group(LinkedHashSet<T> groupElements, Graph<T> graph) {
		this.groupElements = groupElements;
		this.graph = graph;
	}

}