package com.subhjit.test;

public class IsARelationship {

	public static void main(String[] args) {
		Parent p = new Parent(40);
		Child c = new Child(10);
		Parent p1 = new Child(20);
		
		System.out.println("Parent Age :"+c.getMyAge());
		System.out.println("Child Age :"+ c.getChildAge());

	}

}
class Parent{
	int myAge;
	public int getMyAge() {
		return myAge;
	}
	public void setMyAge(int myAge) {
		this.myAge = myAge;
	}
	Parent(int age){
		this.myAge = age;
	}	
}

class Child extends Parent{
	int childAge;

	

	public int getChildAge() {
		return childAge;
	}



	public void setChildAge(int childAge) {
		this.childAge = childAge;
	}



	Child(int age) {
		super(age);	
		this.childAge=age;
	}
	
	
}
