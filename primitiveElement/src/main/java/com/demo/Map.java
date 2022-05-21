package com.demo;

public class Map<G> {
	G argument1;
	G argument2;
	G result;

	public Map(G argument1, G argument2, G result) {
		this.argument1 = argument1;
		this.argument2 = argument2;
		this.result = result;
	}

	public String toString() {
		return String.format("%s×%s=%s", argument1, argument2, result);
	}
}