package com.ajax.test.test;

class Human6{
	// class 변수 : 인스턴스화 작업을 거칠 필요가 없어서
	public static int age;
	
	// 인스턴스화 작업을 거쳐야지만 사용할 수 있는 것 : 인스턴스 변수
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

public class Test6 {
	public static void main(String[] args) {
		System.out.println(Human6.age); // 0
		
		Human6 h = new Human6(); 
		h.age = 20;
		h.setName("Jen");
		
		System.out.println(Human6.age); // 20
		
		Human6 h1 = new Human6();
		h1.age = 31;
		h1.setName("Kyle");
		
		System.out.println(Human6.age); // 31
		
		System.out.println(h.age == h1.age); // true
		System.out.println(Human6.age); // 31
		System.out.println(h.age); // 31
		System.out.println(h1.age); // 31
	}
}

// age : 같은 곳을 바라봄

// 기간제 시스템