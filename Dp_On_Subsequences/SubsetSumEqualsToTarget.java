package Dp_On_Subsequences;

//verified over coding ninjas. I am doing bottom up recursion and bottom up DP here.
import java.util.*;

public class SubsetSumEqualsToTarget {

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, };
		int k = 4;
		int n = arr.length;
		if (subsetSumToKRecursive(arr, k))
			System.out.println("Subset with given target found using recursion");
		else
			System.out.println("Subset with given target not found using recursion");

		if (subsetSumToKMemoized(arr, k))
			System.out.println("Subset with given target found using memoization");
		else
			System.out.println("Subset with given target not found");

		if (subsetSumToKTabulation(arr, k) == 1)
			System.out.println("Subset with given target found using tabulation");
		else
			System.out.println("Subset with given target not found");

	}

	private static int subsetSumToKTabulation(int[] arr, int target) {
		// For tabulation:- (1) Think about basecase (2) Think of changing parameters
		// (states) and Write them in nested loops (3) Copy the recourrence.
		// TODO Auto-generated method stub
		int[][] dp = new int[arr.length + 1][target + 1];
		dp[0][0] = 1;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 && j == 0)
					dp[i][j] = 1;
				else if (i == 0)
					dp[i][j] = 0;
				else if (j == 0)
					dp[i][j] = 1;
				else {
					int take = (j >= arr[i - 1]) ? dp[i - 1][j - arr[i - 1]] : 0;
					int nottake = dp[i - 1][j];
					dp[i][j] = take | nottake;
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static boolean subsetSumToKRecursive(int[] arr, int target) {
		return helper(arr, 0, target);
	}

	public static boolean helper(int[] arr, int idx, int target) {
		if (idx == arr.length) {
			if (target == 0) {
				return true;
//You can see base case par aake jrruri nahi h nottake , take ka or return kare. WE can simply analyze the base case and return either 1 or 0
			}
			return false;
		}

		boolean nottake = helper(arr, idx + 1, target);
		boolean take = (target >= arr[idx]) ? helper(arr, idx + 1, target - arr[idx]) : false;

		return nottake || take;

	}

	private static boolean subsetSumToKMemoized(int[] arr, int target) {
		// TODO Auto-generated method stub
		boolean[][] dp = new boolean[arr.length][target + 1];
		return helperMemo(arr, 0, target, dp);
	}

	public static boolean helperMemo(int[] arr, int idx, int target, boolean[][] dp) {

		if (idx == arr.length) {
			if (target == 0)
				return true;
			return false;
		}

		if (dp[idx][target] != false)
			return dp[idx][target];

		boolean nottake = helper(arr, idx + 1, target);
		boolean take = (target >= arr[idx]) ? helper(arr, idx + 1, target - arr[idx]) : false;
		dp[idx][target] = nottake || take;
		return nottake || take;

	}

}
