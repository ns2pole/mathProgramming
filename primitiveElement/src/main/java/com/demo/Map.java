package com.demo;

public class Map<T> {
	// groupのElement[]を引数にしたコンストラクタ
	Element<T> argument1;
	Element<T> argument2;
	Element<T> result;

	public Map(Element<T> argument1, Element<T> argument2, Element<T> result) {
		this.argument1 = argument1;
		this.argument2 = argument2;
		this.result = result;
	}
}