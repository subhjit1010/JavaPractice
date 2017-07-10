package com.subhjit.test;

import java.util.Scanner;

public class Armstrong {

	public static void main(String[] args) {
		Armstrong result = new Armstrong();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a Number:");
		int number1= input.nextInt();
		System.out.println("Is " +number1+" is Armstrong: "+result.isArmstrong(number1));
		

	}
	public boolean isArmstrong(int number) {
		int sum=0;
		int orignalNumber = number;
		while(number!=0) {
			int reminder = number % 10;
			sum = sum + reminder * reminder * reminder;
			number =number /10;
		}
		return (orignalNumber==sum?true:false);
		
	}

}
