package com.ajax.test.test;

import java.util.ArrayList;
import java.util.List;

class Taxi{
	public List<Human> humans;
	public void getIn(Human h) {
		// lazy loading : 타야지만 생성됨
		if(humans == null) {
			humans = new ArrayList<>();
		}
		humans.add(h);
	}
	public void doBilling() {
		for(Human h:humans) {
			if(h instanceof Driver) {
				Driver d = (Driver)h;
				d.drive();
			} else if(h instanceof Passenger) {
				Passenger p = (Passenger)h;
				p.pay();
			}
		}
	}
}

class Human{
	public String name="";
	public Human(String name) {
		this.name = name;
	}
}

class Driver extends Human{
	public Driver(String name) {
		super(name);
	}
	public void drive() {
		System.out.println(this.name + " : driver");
	}
}

class Passenger extends Human{
	public Passenger(String name) {
		super(name);
	}
	public void pay() {
		System.out.println(this.name + " : Passenger");
	}
}

public class Test15 {
	public static void main(String[] args) {
		Taxi t = new Taxi();
		Human h = new Driver("기사");
		Human h1 = new Passenger("손님");
		t.getIn(h);
		t.getIn(h1);
		t.doBilling();
	}
}

// 기사 : driver
// 손님 : Passenger
