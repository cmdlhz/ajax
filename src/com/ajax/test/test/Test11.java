package com.ajax.test.test;

class Mother11{
	Mother11(String str){
		
	}
}

public class Test11 extends Mother11 {
	private String str;
	
	public Test11(String str) {
		// super(); // 이게 생략되어 있음 // 엄마한테 기본생성자가 없어서 안 됨
		super(str);  // 이렇게 string이라고 부를 것을 넣어줘야 함
		this.str = str;
	}
	public String toString() {
		return "this.str = " + this.str;
	}
	
	public static void main(String[] args) {
		
	}
}