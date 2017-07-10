package com.subhjit.test;

import java.util.HashMap;

public class EqualsAndHashcode {
	public static void main(String args[]) {
		HashMap<Employee, String> hm = new HashMap<Employee, String>();
		hm.put(new Employee(1, "sam"), "employee1 data");
		hm.put(new Employee(2, "amy"), "employee2 data");

		System.out.println("HashMap's data> " + hm);
		System.out.println(hm.get(new Employee(1, "sam")));

		hm.put(new Employee(1, "sam"), "employee1 data OVERRIDDEN");
		System.out.println("\nAgain display HashMap after overriding data " + "of Employee with id=1 and name=’sam’\n");

		System.out.println("HashMap's data> " + hm);
		System.out.println(hm.get(new Employee(1, "sam")));
	}

}

class Employee {
	private Integer id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Employee(Integer id, String Name) {
		this.id = id;
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Employee emp = (Employee) obj;
		return (emp.id == this.id || emp.id.equals(this.id)) && (emp.name == this.name || emp.name.equals(this.name));
	}

	@Override
	public int hashCode() {
		int hash = (this.id == null ? 0 : this.id.hashCode()) + (this.name == null ? 0 : this.name.hashCode());
		return hash;
	}
	@Override
	public String toString() {
		return "Employee [id="+ id +",name="+name +"]";
	}
}