package com.ajax.test.test;

class Mother12{
	public void test12() {
		System.out.println("mom");
	}
}

public class Test12 extends Mother12{
	public void test12() {
		System.out.println("son");
	}
	
	public static void main(String[] args) {
		Mother12 t = new Test12();
		t.test12(); // son
	}
}