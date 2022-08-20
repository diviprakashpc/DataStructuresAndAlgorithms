package Parition_Dp;

public class MCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int matrixMultiplication(int N, int arr[]) {
		// code here
		int[][] dp = new int[N - 1][N - 1];

		for (int gap = 0; gap < dp.length; gap++) {
			for (int i = 0, j = gap; j < dp.length; i++, j++) {
				if (gap == 0) {
					dp[i][j] = 0;
				} else if (gap == 1) {
					dp[i][j] = arr[i] * arr[j] * arr[j + 1];
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int lc = dp[i][k];
						int rc = dp[k + 1][j];
						int mc = arr[i] * arr[k + 1] * arr[j + 1];
						int tc = lc + rc + mc;
						min = Math.min(tc, min);
					}
					dp[i][j] = min;
				}

			}
		}

		return dp[0][dp.length - 1];
	}

}
