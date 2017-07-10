package com.subhjit.test;

public class TryCatchTest {

	public static void main(String[] args) {
		System.out.println(exceptionTest());
	}

	/*public static int exceptionTest() {
		int i = 6;
		try {
			return i;
		} catch (Exception e) {
			i = 10;

		} finally {
			i=10;
			System.out.println("In finally block");
		}
		return i;
	}*/
	/*public static int exceptionTest()
	{
		int i = 6;
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			i = 10;
			return i;
		} finally {
			i = 20;
			System.out.println("In finally block");
		}

	}*/
	
	public static int exceptionTest()
	{
		int i = 6;
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			i = 10;
			throw e;
		} finally {
			i = 20;
			System.out.println("In finally block");
			return i;
		}
	}
	
	/*public static int exceptionTest()
	{
		int i = 6;
		try {
			i = 50;
			return i;
		} finally {
			i = 20;
			System.out.println("In finally block");
			return i;
		}

	}*/
	
}