package Dp_On_LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 4, 11, 1, 16, 8 };
		System.out.println(getLis(arr));

	}

//o(nlogn) method 
	public int lengthOfLIS(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		ans.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > ans.get(ans.size() - 1)) {
				ans.add(nums[i]);
			} else {
				int lb = lower_bound(ans, nums[i]);
				ans.set(lb, nums[i]);
			}
		}
		return ans.size();
	}

	static int lower_bound(List<Integer> array, int key) {

		int lb = Collections.binarySearch(array, key);

		if (lb < 0) {
			return Math.abs(lb) - 1;
		} else {
			int y = array.get(lb);
			int i = lb - 1;
			while (i >= 0 && array.get(i) == y) {
				lb--;
				i--;
			}
		}
		return lb;
	}

	public static int lis1d(int[] arr) { // sc-o(n)
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
		int ans = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int prev = 0; prev < i; prev++) {
				if (arr[prev] < arr[i]&&dp[i]<1+dp[prev]) {
					dp[i] =1+dp[prev];
				}
			}
			ans = Math.max(ans, dp[i]);
		}

		return ans;
	}

	// o(n^2) sc - o(n^2)
	public static int longestIncreasingSubsequence2D(int arr[]) {
		// Your code goes here
		int n = arr.length;
		int[][] dp = new int[n + 1][n + 1];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i - 1; j >= -1; j--) {
				int nottake = dp[i + 1][j + 1];
				int take = 0;
				if (j == -1 || arr[i] > arr[j]) {
					take = 1 + dp[i + 1][i + 1];
				}
				dp[i][j + 1] = Math.max(take, nottake);
			}
		}
		return dp[0][-1 + 1];

	}

	// Dont try to understand 2d , its quite complicated.Remeber 1d only.
	// tc o(n^2) sc o(n^2)
	// exponential

	public static int recursive(int[] arr, int idx, int prev_idx) {
		if (idx == arr.length)
			return 0;

		int nottake = recursive(arr, idx + 1, prev_idx);
		int take = 0;

		if (prev_idx == -1 || arr[idx] > arr[prev_idx]) {
			take = 1 + recursive(arr, idx + 1, idx);
		}
		return Math.max(take, nottake);
	}

	public static String getLis(int[] arr) {
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
		int[] navigate = new int[arr.length];
		for (int i = 0; i < navigate.length; i++)
			navigate[i] = i;
		int len = 0;
		int idx = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int prev = 0; prev < i; prev++) {
				if (arr[prev] < arr[i]) {
					if (1 + dp[prev] > dp[i]) {
						dp[i] = 1 + dp[prev];
						navigate[i] = prev;
					}
				}
			}
			if (dp[i] > len) {
				len = dp[i];
				idx = i;
			}

		}
		List<Integer> temp = new ArrayList<>();
		while (navigate[idx] != idx) {
			temp.add(arr[idx]);
			idx = navigate[idx];
		}
		temp.add(arr[idx]);
		Collections.reverse(temp);
		String lis = "";
		for (Integer i : temp) {
			lis += (i + " ");
		}

		return lis;

	}

}
