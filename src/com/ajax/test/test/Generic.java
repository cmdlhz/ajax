package com.ajax.test.test;

import java.util.ArrayList;
import java.util.List;

class Gen<T>{
	List<T> gList;
	
	public void add(T t) {
		if(gList == null) {
			gList = new ArrayList<>();
		}
		gList.add(t);
	}
}

// K : Key
// V : Value
// T : Type
// E : Element

// map => public interface Map<K,V>{ ... }

// Generic으로 공통을 만들거나 Interface로 공통을 만듦 
// (wildcards 라는 것도 있음)

// 우리나라에서 Interface로 구조를 짜기 힘듦

public class Generic {
	public static void main(String[] args) {
		// 같은 gen class라고 하더라도 쓸 수 있는 type이 달라질 수 있음
		Gen<String> gen = new Gen<String>();
		Gen<Generic> gen1 = new Gen<Generic>();
		
		String a = "abc";
		gen.add(a);
		
		
//		List<Object> gList = new ArrayList<>();
//		// same as
//		// List gList = new ArrayList();
//		
//		String str = "123";
//		Integer i = 3;
//		Generic g = new Generic();
//		gList.add(str);
//		gList.add(i);
//		gList.add(g);
//		System.out.println(gList); // [123, 3, com.ajax.test.test.Generic@7852e922]
	}
}
