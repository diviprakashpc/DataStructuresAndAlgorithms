package Sliding_Window;

public class MaximumSumSubarrayOfSizeK {
	/*
	 * 1)window size = j - i + 1; j->end of window i->start of window
	 * 
	 * 2)initialize i = 0, j = 0 . Check if window size == k.If less then keep
	 * incrementing j.
	 * 
	 * 3)Now we have i and j with window size k. We now do calculations on this
	 * window. And move this window by adding next element in it and removing
	 * element at i.
	 * 
	 * 4)Number of subarrays possible having fixed window k for array of size n is n
	 * - (k-1).
	 * 
	 * Also, We incremented j at the begining till window size = k. Instead we could
	 * have initialized j as i+k-1. That is also correct but then to calcuate sum
	 * between the initial window we again had to traverse it. So instead we created
	 * the window step by step and worked(calculations which is sum here) on the
	 * elements.
	 * 
	 */

	/*
	 * Yhi template follow hota h neeche likha jo hai generally in fixed sliding window. Bs calculations
	 * diffrent hoti hai
	 */
	public int maxsubarraysumofsizek(int[] arr, int k) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int max = 0;
		while (j < arr.length) {
			sum = sum + arr[j]; // calc1
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				max = Math.max(max, sum); // calc2
				sum = sum - arr[i]; // calc3
				j++;
				i++;
			}
		}

		return max;
	}

}
