package com.subhjit.test.array;

import java.util.Arrays;

public class StringAnagramMain {

	public static void main(String[] args) {

		String word = "java2blog";
		String anagram = "aj2vabgol";

		System.out.println("java2blog and aj2vabgol are anagrams :" + isAnagramUsingArraySort(word, anagram));

	}

	public static boolean isAnagramUsingArraySort(String word, String anagram) {

		String sortedWord = sortChars(word);
		String sortedAnagram = sortChars(anagram);

		return sortedWord.equals(sortedAnagram);
	}

	public static String sortChars(String word) {
		char[] wordArr = word.toLowerCase().toCharArray();
		Arrays.sort(wordArr);
		return String.valueOf(wordArr);
	}
}