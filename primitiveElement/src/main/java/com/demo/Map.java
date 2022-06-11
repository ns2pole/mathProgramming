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
	@Override
	public boolean equals(Object o) {
		Map m = (Map) o;
		return (this.argument1.equals(m.argument1) && this.argument2.equals(m.argument2) && this.result.equals(m.result));
	}
}