package Catalannumbers;

public class PrintCatalanSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i = 0 ; i <=10 ; i++) {
        	System.out.println(catalanValue(i));
        }
	}
	
	public static int catalanValue(int n) {
		int[] dp = new int[n+1];
		if(n==0||n==1) return 1;
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <=n ; i++) {
			for(int j = 0 ; j<=i-1 ; j++) {
				int left = dp[j];
				int right = dp[i-j-1];
				dp[i]+=(left*right);
			}
		}
		return dp[n];
	}

}
