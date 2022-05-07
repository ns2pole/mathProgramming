package com.demo;
import java.util.LinkedHashSet;
import java.util.ArrayList;

public class Set<T> {
	LinkedHashSet<Element<T>> elements;

	public Element<T> getElementHas(T val) {
		ArrayList<Element<T>> elementList = new ArrayList<Element<T>>(this.elements);
		for(int i = 0; i < elementList.size(); i++) {
			if(val.equals(elementList.get(i).val)) {
				return elementList.get(i);
			}
		}
		return new Element<T>(null);
	}

}