package com.ajax.test.test;

class Human5{
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

public class Test5 {
	public static void main(String[] args) {
		Human5 h = new Human5();
		h.setName("Jen");
		
		// new 할 때 JVM이 메모리 생성해줌
		Human5 h1 = new Human5();
		h1.setName("Kyle");
		
		System.out.println(h);
		System.out.println(h1);
		
		// 메모리 생성을 하지 않아도 사용 가능
		System.out.println(Human5.age); // 0 (load할 때 초기화 해줌)
	}
}

// "new" : instantiate 인스턴스화

// Java에는 undefined 개념을 알고는 있지만 표현이 안 됨 => 컴파일 자체가 안 됨 int a; 이러고 끝내면 안 됨 / 에러남