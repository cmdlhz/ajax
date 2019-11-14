package com.ajax.test.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Mother14{
	public void test14() {
		System.out.println("mom");
	}
}

public class Test14 extends Mother14{
	public void test14() {
		System.out.println("son");
	}
	
	public void testPlus() {
		System.out.println("as well");
	}
	
	public static void main(String[] args) {
		Mother14 t = new Test14();
		if(t instanceof Test14) { // 맞는지 물어보는 게 중요
			Test14 t1 = (Test14)t; 
			t1.testPlus(); // as well
		}
		List<String> list = new ArrayList<>();
		//java.util.ArrayList cannot be cast to java.util.LinkedList
		// 바꿔도 되는지 물어봐야 함 
		LinkedList ll = (LinkedList)list;
	}
}
