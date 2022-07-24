package Dp_On_Strings;
//Very important structure. Used in many ques like LCSubstring, LPSubsequence .
public class LCS {
    public static void main(String[] args) {}
    
    public static int tabulation1D(String s , String t) {
    	int[] prev = new int[t.length()+1];
        int[] curr = new int[t.length()+1];
        
        for(int i = 0 ; i <= t.length() ; i++){
          prev[0] = 0;
        }
        
        for(int i = 1 ; i <= s.length() ; i++){
            for(int j = 1; j<=t.length() ; j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }else{
                    curr[j] = Math.max(prev[j],curr[j-1]);
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[t.length()];
    }
    
    public static int tabulation2D(String s, String t) {
    	 int[][] dp  = new int[s.length()+1][t.length()+1];
    	 for(int i = 0 ; i <= s.length()  ; i++){
             dp[i][0] = 0;     
         }
        
        for(int j = 0 ; j<=t.length();j++){
            dp[0][j] = 0;
        }
         
         for(int i = 1 ; i <= s.length() ; i++){
             for(int j = 1; j<=t.length() ; j++){
                 if(s.charAt(i-1)==t.charAt(j-1)){
                     dp[i][j] = 1 + dp[i-1][j-1];
                 }else{
                     dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                 }
             }
         }
         return dp[s.length()][t.length()];
         
    }
    
    public static int recursive(String s1, String s2, int idx1, int idx2) {
    	 if(idx1<0||idx2<0) return 0;
         
         if(s1.charAt(idx1)==s2.charAt(idx2)){
             return 1 + recursive(s1,s2,idx1-1,idx2-1);
         }
         return Math.max(recursive(s1,s2,idx1-1,idx2),recursive(s1,s2,idx1,idx2-1));
     }
    }

