package org.example.Study1;

public class Customer {
	String name;
	String surname;

	public Customer(String name, String surname) {
		this.name = name;
        this.surname = surname;
	}
	public String getFullName(){
		return name+surname;
	}
}
