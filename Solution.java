import java.util.*;
public class Solution {
   static int mi = -1;
   static int mj = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,3,4,-17,5,6,7};
     
        System.out.println(solve(arr)+"at "+mi +" -> " + mj);
	}
	
	public static int solve(int[] arr) {
    
		int i = 0;
		int j = 0;
		int cs = 0;
		int ms  = Integer.MIN_VALUE;
		while(j<arr.length) {
			cs+=arr[j];
			if(cs<0) {
				 j++;
			     i = j;
			     cs = 0;
				continue;
			}else {
				if(cs>ms) {
					mi = i;
					mj = j;
					ms = cs;
				}
				j++;
				System.out.println(cs);
			}
		}
		if(cs>ms) {
			mi = i;
			mj = j;
			ms = cs;
		}
		return ms;
	}

}
