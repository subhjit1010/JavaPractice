package com.subhjit.test.array;

public class StringRemoveSpaces {
	public static void main(String[] args) {
		  String str = "     Hello world from   java2blog.com  ";
		  System.out.println("------------------------------");
		  System.out.println("Using replaceAll");
		  System.out.println("------------------------------");
		 
		                // Using replaceAll
		  String result1 = str.replaceAll("\\s", "");
		  System.out.println(result1);
		 
		  String result2 = "";
		  // Using iteration
		  System.out.println("n------------------------------");
		  System.out.println("Using Iteration");
		  System.out.println("------------------------------");
		  for (int i = 0; i < str.length(); i++) {
		   if (!Character.isWhitespace(str.charAt(i))) {
		    result2 += str.charAt(i);
		   }
		  }
		  System.out.println(result2);
		 }
}