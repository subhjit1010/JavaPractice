package com.subhjit.test;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a String :");
		String str = input.next();
		reveseUsingLoop(str);
		System.out.println("\nReverse of " + str + " Using Recursive is:" + reverseUsingRecursive(str));

	}

	public static void reveseUsingLoop(String str) {
		String reverse = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		System.out.println("Reverse of " + str + " is:" + reverse);
	}

	public static String reverseUsingRecursive(String str) {
		if (str.length() < 1) {
			return str;
		}

		return reverseUsingRecursive(str.substring(1)) + str.charAt(0);

	}

}
