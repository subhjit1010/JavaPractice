package com.subhjit.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDeserialize {
	public static void main(String args[]) throws IOException {
		Employee1 emp = new Employee1();
		emp.setEmployeeId(101);
		emp.setEmployeeName("Subhjit");
		emp.setDepartment("IT");
		Address address = new Address(15,"WhiteField","Bangalore");
		emp.setAddress(address);
		//Serialize
		try {
			FileOutputStream fout = new FileOutputStream("employee1.ser");
			try {
				ObjectOutputStream outputStram = new ObjectOutputStream(fout);
				outputStram.writeObject(emp);
				outputStram.close();
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Deserialize
		FileInputStream fin = new FileInputStream("employee1.ser");
		ObjectInputStream inputStream = new ObjectInputStream(fin);
		try {
			emp = (Employee1) inputStream.readObject();
			inputStream.close();
			fin.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Deserialized Employee...");
		  System.out.println("Emp id: " + emp.getEmployeeId());
		  System.out.println("Name: " + emp.getEmployeeName());
		  System.out.println("Department: " + emp.getDepartment());
		  address=emp.getAddress();
		  System.out.println("City :"+address.getCity());
	}

}
class Employee1 implements Serializable{
	private static final long serialVersionID =1L;
	int employeeId;
	String employeeName;
	String department;
	Address address;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}

class Address{
	int homeNo;
	String street;
	String city;
	
	public Address(int homeNo, String street, String city) {
		super();
		this.homeNo = homeNo;
		this.street = street;
		this.city = city;
	}
	public int getHomeNo() {
		return homeNo;
	}
	public void setHomeNo(int homeNo) {
		this.homeNo = homeNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
