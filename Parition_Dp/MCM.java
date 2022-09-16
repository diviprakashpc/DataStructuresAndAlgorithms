package Parition_Dp;

public class MCM {

static int helper(int[] arr, int i, int j){
    // base condition
    if(i == j)
        return 0;   
    int mini = Integer.MAX_VALUE;
    // partioning loop
    for(int k = i; k<= j-1; k++){
    	int left_count = helper(arr,i,k);
    	int right_count = helper(arr, k+1,j);
        int total_count = left_count+ right_count + arr[i-1]*arr[k]*arr[j];
        mini = Math.min(mini,total_count);    
    }
    
    return mini;
}
static int matrixMultiplication(int[] arr, int N){
    int i =1;
    int j = N-1;
    return helper(arr,i,j);   
}

	static int matrixMultiplicationGapStrategy(int N, int arr[]) {
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

 
public static void main(String args[]) {
	
	int arr[] = {10, 20, 30, 40, 50};
	
	int n = arr.length;
	
	System.out.println("The minimum number of operations are "+
        matrixMultiplication(arr,n));
	
}	

}
