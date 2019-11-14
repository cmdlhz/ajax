package com.ajax.test.test;

class Mother13{
	public void test13() {
		System.out.println("mom");
	}
}

public class Test13 extends Mother13{
	public void test13() {
		System.out.println("son");
	}
	
	public void testPlus() {
		System.out.println("as well");
	}
	
	public static void main(String[] args) {
		Mother13 t = new Test13();
		System.out.println(t instanceof Test13); // true
		t.test13(); // son
		// t.testPlus(); // ERROR (Parent class에 없으므로)
		
		Test13 t1 = (Test13)t;
		System.out.println(t1 instanceof Test13); // true
		t1.test13(); // son
		t1.testPlus(); // as well
	}
}

// 상속관계 => 상하관계 (Parent는 위에 있고 children은 아래에 있다)