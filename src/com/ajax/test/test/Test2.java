package com.ajax.test.test;

import java.util.ArrayList;
import java.util.List;

class Human2{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Human [name=" + name + "]";
	}
}

public class Test2 {
	public static void main(String[] args) {
		List<Human2> hList = new ArrayList<>();
		hList.add(new Human2());
		Human2 h = new Human2();
		hList.add(h);
		hList.get(0).setName("Jen");
		System.out.println(hList.get(1).getName()); // null
	}
}
