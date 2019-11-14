package com.ajax.test.test;

import java.util.ArrayList;
import java.util.List;

class Human3{
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

public class Test3 {
	public static void test3(List<Human3> hList) {
		hList.get(0).setName("Jen");
	}
	public static void main(String[] args) {
		List<Human3> hList = new ArrayList<>();
		hList.add(new Human3());
		test3(hList);
		System.out.println(hList.get(0).getName()); // "Jen"
	}
}
