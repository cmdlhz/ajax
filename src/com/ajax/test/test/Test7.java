package com.ajax.test.test;

import java.util.HashMap;
import java.util.Map;

class Mother{
	public Mother() {
		
	}
}

public class Test7 extends Mother {
	String str;
	
	//overriding: 생성자 자기 class와 이름이 같아하는데 그렇게 안 되므로 
//	public Mother() {
//		
//	}
	
	public Test7() {
		
	}
	// overloading
	public Test7(String str) {
		
	}
	
	public static void main(String[] args) {
		Map<String,Test7> map = new HashMap<>(); // hash 연산 이해하기 진짜 어려움!
		map.put("n1", new Test7());
	}
}

// 단일 상속! (C#은 다중 상속 됨!)