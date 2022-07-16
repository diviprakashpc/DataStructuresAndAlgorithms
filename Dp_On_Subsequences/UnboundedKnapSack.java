package Dp_On_Subsequences;

//Knapsack but an item can be picked any number of time --> Therefore Infinite Supply
//This structure is used for all problems with infinite supply in this list of ques..
public class UnboundedKnapSack {

	public static void main(String[] args) {
	}

	public static int recursive(int idx, int[] value, int[] weight, int maxWeight) {
		if (idx == 0) {
			return (int) (maxWeight / weight[0]) * value[0];
		}

		int nottake = recursive(idx - 1, value, weight, maxWeight);
		int take = Integer.MIN_VALUE;
		if (weight[idx] <= maxWeight) {
			take = value[idx] + recursive(idx, value, weight, maxWeight - weight[idx]);
			// idx dont decrement, because we can take the same item again
		}

		return Math.max(take, nottake);
	}

	public static int Tabulation(int n, int[] value, int[] weight, int maxWeight) {
		int[][] dp = new int[n][maxWeight + 1];

		for (int wt = 0; wt <= maxWeight; wt++) {
			dp[0][wt] = (wt / weight[0]) * value[0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= maxWeight; j++) {
				int nottake = dp[i - 1][j];
				int take = Integer.MIN_VALUE;
				if (weight[i] <= j) {
					take = value[i] + dp[i][j - weight[i]];
				}
				dp[i][j] = Math.max(nottake, take);
			}
		}
		return dp[n][maxWeight];

	}

	public static int _1dOptimizedTabulation(int n, int[] value, int[] weight, int maxWeight) {

		int[] prev = new int[maxWeight + 1];
		int[] curr = new int[maxWeight + 1];
		for (int wt = 0; wt <= maxWeight; wt++) {
			prev[wt] = (wt / weight[0]) * value[0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= maxWeight; j++) {
				int nottake = prev[j];
				int take = Integer.MIN_VALUE;
				if (weight[i] <= j) {
					take = value[i] + curr[j - weight[i]];
				}
				curr[j] = Math.max(nottake, take);
			}
			int[] temp = prev;
			prev = curr;
			curr = temp;
		}
		return prev[maxWeight];
	}

	public static int bestOptimal1DArray(int n, int maxWeight, int[] value, int[] weight) {
		int[] prev = new int[maxWeight + 1];
		for (int wt = 0; wt <= maxWeight; wt++) {
			prev[wt] = (wt / weight[0]) * value[0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= maxWeight; j++) {
				int nottake = prev[j];
				int take = Integer.MIN_VALUE;
				if (weight[i] <= j) {
					take = value[i] + prev[j - weight[i]];
				}
				prev[j] = Math.max(nottake, take);
			}
		}
		return prev[maxWeight];
	}

}

/*
 * You are given ‘N’ items with certain ‘PROFIT’ and ‘WEIGHT’ and a knapsack
 * with weight capacity ‘W’. You need to fill the knapsack with the items in
 * such a way that you get the maximum profit. You are allowed to take one item
 * multiple times.
 */