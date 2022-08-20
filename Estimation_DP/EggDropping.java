package Estimation_DP;

public class EggDropping {
	/*
	 * You are given N identical eggs and you have access to a K-floored building
	 * from 1 to K.
	 * 
	 * There exists a floor f where 0 <= f <= K such that any egg dropped at a floor
	 * higher than f will break, and any egg dropped at or below floor f will not
	 * break. There are few rules given below.
	 * 
	 * An egg that survives a fall can be used again. A broken egg must be
	 * discarded. The effect of a fall is the same for all eggs. If the egg doesn't
	 * break at a certain floor, it will not break at any floor below. If the eggs
	 * breaks at a certain floor, it will break at any floor above. Return the
	 * minimum number of moves that you need to determine with certainty what the
	 * value of f is.
	 */
	
	/* breaks -> one egg less and neeche check kro for critical floor
	 * survives-> same no of eggs and upar check kro for critical floor
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int eggDrop(int n, int k) {
		// Your code here
		int[][] dp = new int[n + 1][k + 1];
		for (int j = 1; j <= k; j++) {
			dp[1][j] = j;
		}

		for (int i = 1; i <= n; i++) {
			dp[i][1] = 1;
		}

		for (int eggs = 2; eggs <= n; eggs++) {
			for (int floor = 2; floor <= k; floor++) {
				int min = Integer.MAX_VALUE;
				for (int i = 1; i <= floor; i++) {
					int breaks = 1 + dp[eggs - 1][i - 1];
					int notbreaks = 1 + dp[eggs][floor - i];
					min = Math.min(min, Math.max(breaks, notbreaks));
				}
				dp[eggs][floor] = min;
			}
		}

		return dp[n][k];
	}

	static int helper(int n, int f, int[][] dp) {
		if (f == 0 || n == 0)
			return 0;
		if (n == 1)
			return f;
		if (f == 1)
			return 1;
		if (dp[n][f] != -1)
			return dp[n][f];
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= f; i++) {
			int breaks = 1 + helper(n - 1, i - 1, dp);
			int notbreaks = 1 + helper(n, f - i, dp);
			min = Math.min(min, Math.max(breaks, notbreaks));
		}

		return dp[n][f] = min;
	}

}
