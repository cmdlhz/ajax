package com.ajax.test.test;

public class Test10 {
	private String str;
	
	public Test10(String str) {
		this.str = str;
	}
	public String toString() {
		return "this.str = " + this.str;
	}
	
	public static void main(String[] args) {
		// 여기서 this = t
		Test10 t = new Test10("why");
		System.out.println(t);
		// 여기서 this = t2
		Test10 t2 = new Test10("answer");
		System.out.println(t2);
	}
}