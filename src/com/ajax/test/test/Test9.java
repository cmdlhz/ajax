package com.ajax.test.test;

import java.util.HashMap;
import java.util.Map;

public class Test9 {
	private String str;
	
	// throws Exception 사용해서 exception을 강조해도 됨
	public Test9(String str) {
		if(str == null) {
			throw new RuntimeException("null을 사용할 수 없습니다.");
		}
		this.str = str;
	}
	public String toString() {
		return "this.str = " + this.str;
	}
	
	public static void main(String[] args) {
		Map<String, Test9> map = new HashMap<>();
		Test9 t9 = new Test9("NA");
		map.put("n1", t9);
		
		t9 = new Test9("YAY");
		map.put("n2", t9);
		
		t9 = new Test9("HA");
		
		System.out.println(map); // {n1=this.str = NA, n2=this.str = YAY}
	}
}
