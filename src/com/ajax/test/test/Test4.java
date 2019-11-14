package com.ajax.test.test;

import java.util.ArrayList;
import java.util.List;

class Human4{
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

public class Test4 {
	public static List<Human4> test4(List<Human4> hList) {
		hList.get(0).setName("Jen");
		return null;
	}
	public static void main(String[] args) {
		List<Human4> hList = new ArrayList<>();
		hList.add(new Human4());
		test4(hList); // hList = test4(hList); 면 문제가 생기겠지만...
		System.out.println(hList.get(0).getName()); // "Jen"
	}
}
