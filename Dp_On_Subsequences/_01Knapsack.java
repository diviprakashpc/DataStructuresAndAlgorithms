package Dp_On_Subsequences;

//Verified from coding ninjas . I am doing Top down recursion and bottom up DP.
public class _01Knapsack {
	public static void main(String args[]) {

	}

	static int knapsack01(int[] weight, int ind, int[] value, int n, int maxWeight) {
		if (ind == 0) {
			if (weight[ind] <= maxWeight)
				return weight[ind];
			return Integer.MIN_VALUE;
		}

		int nottake = knapsack01(weight, ind - 1, value, n, maxWeight);
		int take = Integer.MIN_VALUE;
		if (weight[ind] <= maxWeight)
			take = value[ind] + knapsack01(weight, ind - 1, value, n, maxWeight - weight[ind]);

		return Math.max(take, nottake);
	}

	static int knapsack2DDp(int[] weight, int[] value, int n, int maxWeight) {

		int[][] dp = new int[n][maxWeight + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0) {
					if (weight[i] <= j)
						dp[i][j] = value[i];
					else
						dp[i][j] = 0;
				} else {
					int nottake = dp[i - 1][j];
					int take = 0;
					if (weight[i] <= j) {
						take = value[i] + dp[i - 1][j - weight[i]];
					}
					dp[i][j] = Math.max(take, nottake);
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];

	}

	static int knapsack1DDp(int[] weight, int[] value, int n, int maxWeight) {
//i-->index j-->weight
		int[] curr = new int[maxWeight + 1];
		int[] prev = new int[maxWeight + 1];

		for (int j = 0; j <= maxWeight; j++) {
			if (weight[0] <= j) {
				prev[j] = value[0];
			} else
				prev[j] = 0;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= maxWeight; j++) {
				int nottake = prev[j];
				int take = Integer.MIN_VALUE;
				if (weight[i] <= j) {
					take = value[i] + prev[j - weight[i]];
				}
				curr[j] = Math.max(take, nottake);
			}
			int[] temp = prev;
			prev = curr;
			curr = temp;
		}

		return prev[maxWeight];

	}

	static int knapsack1MostOptimal(int[] weight, int[] value, int n, int maxWeight) {
//i-->index j-->currweightlimit
		int[] dp = new int[maxWeight + 1];
		for (int j = weight[0]; j <= maxWeight; j++) {
			dp[j] = value[0];
		}
		for (int i = 1; i < n; i++) {
			for (int j = maxWeight; j >= 0; j--) {
				int nottake = dp[j];
				int take = Integer.MIN_VALUE;
				if (weight[i] <= j) {
					take = value[i] + dp[j - weight[i]];
				}
				dp[j] = Math.max(take, nottake);
			}

		}

		return dp[maxWeight];

	}
}
