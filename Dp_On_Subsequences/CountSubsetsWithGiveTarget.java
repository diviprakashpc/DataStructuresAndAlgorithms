package Dp_On_Subsequences;

public class CountSubsetsWithGiveTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int recursive(int[] arr, int idx, int target) {
		 if(idx==0){
	           if(arr[0]==0&&target==0) return 2;    //tb do tarike h lenge ya nahi lenge
	           if(arr[0]==0||arr[0]==target) return 1;  // first case meei nahi lene ka ek tarika and second case mei lene ka ek tarika
	           return 0;
	        }
	        int nottake  = recursive(arr,idx-1,target);
	        int take = recursive(arr,idx-1,target-arr[idx]);
	        return take+nottake;
	}

	public static int tabulation(int[] arr, int tar) {
		// Write your code here..
		 int[][] dp = new int[arr.length][tar+1];
	        if(arr[0]==0) dp[0][0] = 2;   //whi  case agar both arr[0] and target = 0 ho.   
	        else dp[0][0] = 1;    //wrna agar sirf target 0 ho
	        if(arr[0]!=0&&arr[0]<=tar) dp[0][arr[0]] = 1;   //arr[0] = targte
	        for(int i = 1 ;  i < arr.length ; i++){
	            for(int j = 0 ; j <= tar ; j++){
	                    int take = (j>=arr[i]) ? dp[i-1][j-arr[i]] : 0;
	                    int nottake = dp[i-1][j];
	                    dp[i][j] = take + nottake;
	            }
	        }
	        return dp[arr.length-1][tar];

	}

}
