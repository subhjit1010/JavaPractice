package com.subhjit.test;

public class Test1 {

	public static void main(String[] args) {
		String s1 = "Subhjit";
		s1.concat("dutta");
		final StringBuffer s2 = new StringBuffer("Subhjit");
		s2.append("dutta");
		System.out.println("S1="+s1);
		System.out.println("S2="+s2.toString());

	}

}
