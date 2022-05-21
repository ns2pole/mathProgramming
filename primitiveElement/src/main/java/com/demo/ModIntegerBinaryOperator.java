package com.demo;
import java.util.LinkedHashSet;

public class ModIntegerBinaryOperator implements BinaryOperator<ModInteger> {
	int modulo;

	public ModIntegerBinaryOperator(int modulo) {
		this.modulo = modulo;
	}

	public ModInteger calc(ModInteger left, ModInteger right) {
		return new ModInteger((left.val * right.val) % modulo);
	};
}