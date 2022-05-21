package com.demo;
import java.util.LinkedHashSet;

public interface BinaryOperator<A> {
	public A calc(A left, A right);
}