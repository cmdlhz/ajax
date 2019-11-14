package com.ajax.test.test;

class Human1{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

public class Test {
	// 여기서는 접근 제어자 사용 가능
	
	public static void setName(Human1 h) {
		// 여기서 h.setName("123"); 이라고도 하고 밑에 h = new Human(); 라고 하면 123 나옴
		// 여기서 h = new Human() 이라고 하면 밑에 null 나옴 // 선언할 때 끊기므로
		h.setName("123");
	}
	
	public static void main(String[] args) {
		// method 안에 있어서 여기서는 접근 제어자 사용 불가능
		String str = ""; // final로 선언되어 있어서 상속불가

		Human1 h = new Human1();
		setName(h);
		System.out.println(h.getName());
	}
	
	// 여기서는 접근 제어자 사용 가능
}

// class에서 public이 들어갈 수 있는 경우 : innerClass이거나 자바 파일과 이름이 같아야 한다.

// method 혹은 variable은 반드시 특정 영역 안에 있어야 한다.

// 시작점 : public static void main(String[] args)

// 자바는 선언할 때부터 변수 data type을 지정해줘야 함! : primitive vs reference types

// TRUE 
// String str = "" == String str1 = ""
// FALSE
// String str = "" == new String str1 = ""

// public > protected > default > private

// static 공용으로 사용하기 위해서 만드는데