package Dp_Gap_Strategy_A_Way_To_Tabulate;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countSubstrings(String s) {
		if (s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int count = 0;
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = gap; j < dp.length; i++, j++) {
				if (gap == 0) {
					dp[i][j] = true;

				} else if (gap == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				}

				if (dp[i][j] == true)
					count++;
			}
		}

		return count;
	}

}
