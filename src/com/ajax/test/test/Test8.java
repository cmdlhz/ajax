package com.ajax.test.test;

import java.util.HashMap;
import java.util.Map;

public class Test8 {
	private String str;
	
	// throws Exception 사용해서 exception을 강조해도 됨
	public Test8(String str) {
		if(str == null) {
			throw new RuntimeException("null을 사용할 수 없습니다.");
		}
		this.str = str;
	}
	public String toString() {
		return "this.str = " + this.str;
	}
	
	public static void main(String[] args) {
		Map<String, Test8> map = new HashMap<>();
		Test8 t8 = new Test8("halo");
		map.put("n1", t8);
		System.out.println(t8); // this.str = halo
	}
}
