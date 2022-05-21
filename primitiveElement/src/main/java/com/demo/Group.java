package com.demo;
import java.util.LinkedHashSet;

public class Group<G> {
	LinkedHashSet<G> groupElements;
	Graph<G> graph;

	Group(LinkedHashSet<G> groupElements, Graph<G> graph) {
		this.groupElements = groupElements;
		this.graph = graph;
	}

}