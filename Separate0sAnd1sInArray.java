package com.subhjit.test.array;

public class Separate0sAnd1sInArray {

	public static void main(String[] args) {
		int arr[] = {0,1,0,0,1,1,1,0,1};
		separate0s1sSolution1(arr);
		for(int i=0;i<arr.length;i++)
		System.out.println(arr[i]);

	}
	public static int[] separate0s1sSolution1(int arr[])
	 {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0)
				count++;
		}
		for(int i=0;i<count;i++) {
			arr[i]=0;
		}
		for(int i=count;i<arr.length;i++) {
			arr[i]=1;
		}
		
		return arr;
		
	 }

}
