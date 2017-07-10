package com.subhjit.test.array;

public class ContiguousSubarraySum {

	public static void main(String[] args) {
		int arr[] = { 14, 12, 70, 15, 99, 65, 21, 90 };
		int X = 97;
		//findSubArraySumEqualToX(arr, X);
		findSubArraySumEqualToXOptimized(arr, X);
	}

	static void findSubArraySumEqualToX(int arr[], int X) {
		int currentSum;
		for (int i = 0; i < arr.length; i++) {
			currentSum = arr[i];
			// try all subarrays starting with 'i'
			for (int j = i + 1; j <= arr.length; j++) {
				if (currentSum == X) {
					int endIndexForContArray = j - 1;
					System.out.println("Sum found between indexes " + i + " and " + endIndexForContArray);
					for (int k = i; k <= endIndexForContArray; k++) {
						System.out.print(arr[k] + " ");
					}
					return;
				}
				if (currentSum > X || j == arr.length)
					break;
				currentSum = currentSum + arr[j];
			}
		}

		System.out.println("No subarray found");
		return;
	}

	public static void findSubArraySumEqualToXOptimized(int arr[], int X) {
		int currentSum = arr[0];
		int start = 0;

		for (int i = 1; i <= arr.length; i++) {
			// If currentSum is more than the sum, start removing starting elements unless
			// you get currentSum is less than X
			while (currentSum > X && start < i - 1) {
				currentSum = currentSum - arr[start];
				start++;
			}

			// If currentSum becomes equal to sum, then print the index
			if (currentSum == X) {
				int endIndexForContArray = i - 1;
				System.out.println("Sum found between indexes " + start + " and " + endIndexForContArray);
				System.out.println("Printing Array values : ");
				for (int j = start; j <= endIndexForContArray; j++) {
					System.out.print(arr[j] + " ");
				}
				return;
			}

			// Add this element to currentSum
			if (i < arr.length)
				currentSum = currentSum + arr[i];
		}
	}
}
