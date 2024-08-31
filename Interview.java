// import java.util.*;
// public class Interview {
	
	
	

// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
//         List<List<Integer>> matrix = new ArrayList<>();
//         Pair ans = solve(nums);
//         System.out.println(ans.msp);
// 	}
	
// 	public Pair solve(int[][] root) {
// 		if(root==null) return new Pair(0,Integer.MIN_VALUE);
		
// 		Pair left = solve(root.left);
// 		Pair right = solve(root.right);
// 		int op1 = root.val + left.ntr + right.ntr; //15 _ 20 + 7
// 		int op2 = left.msp; // 15
// 		int op3 = right.msp;  // 7
		
// 		//
// 		return new Pair(Math.max(root.val+left.ntr, root.val+right.ntr),Math.max(op1,Math.max(op2, op3)));
// 	}
	
// 	static class Pair{
// 		int ntr;
// 		int msp;
// 		Pair(int ntr , int msp){
// 			this.ntr = ntr;
// 			this.msp = msp;
// 		}
// 	}

// }


// You are given a 2D array of integer envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
// One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
// Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
// Note: You cannot rotate an envelope.
 
// Example 1:
// Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
// Output: 3
// Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

// Example 2:
// Input: envelopes = [[1,1],[1,1],[1,1]]
// Output: 1

// 1 ,  3 , 2 ,7 ,5 
// Constraints:
// 1 <= envelopes.length <= 105
// envelopes[i].length == 2
// 1 <= wi, hi <= 105
 
// Static class Pair{
// Int ht;
// Int wt;
// //constructor
// }
 
// fn(int[][] nums){
// Pair[] p = new Pair[nums.length];
// for(int i = 0 ; i < nums.length ; i++){
 
// P[i] = new Pair(nums[i][0],nums[i][1]);
 
// }
 
 
// Arrays.sort(p,(a,b)->(b.ht!=a.ht)?b.ht-a.ht:b.wt-a.wt);
// Int ans =  lis(p);
 
// Return ans;
// }


 
// [2,3] [5,4] [ 6,5] [6,7]
// Public int lis(Pair[] pairs){

// List<Pair> list = new ArrayList<>();

// for(int i =  0 ; i < pairs.length ; i++){
 
// Pair p = pairs[i];
// //if height is same then we continue;
// //handling the empty case;
// if(list.size()>0&&p.w>list.get(list.size()-1)) list.add(p.w);
// Else {
// Int idx = findCeil(list,p);
// Pair temp = list[idx];
// list[idx] = pairs[i];
// list[i] = temp;
// }



// }
// Return list.size();

// }


// Public int findCeil(Pair[] pairs, Pair key){
 
// Int l = 0;
// Int h = pairs.length-1;
// Int ans = -1
// while(l<=h){
// M = (l+h)/2;
// if(pairs[m].w<key.w){
//   L = m + 1;
// }else{
//  idx  = m;
// H = m-1;
// }

// Return idx;
// }


// }
























// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
// The path sum of a path is the sum of the node's values in the path.
// Given the root of a binary tree, return the maximum path sum of any non-empty path.
 
// Example 1:

// Input: root = [1,2,3]
// Output: 6
// Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 
// Example 2:

// Input: root = [-10,9,20,null,null,15,7]
// Output: 42
// Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 
//  [min,min,15+20+7,20]
 
// [20+15,42]
 
// [9,min]
// [35,42]
 
// [min,42,9+-10+35,-10]
// [-10+9-10+35]
// [
// Constraints:
// The number of nodes in the tree is in the range [1, 3 * 104].
// -1000 <= Node.val <= 1000



// import java.util.*;
// public class Interview {
	
	
	

// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
//         List<List<Integer>> matrix = new ArrayList<>();
//         Pair ans = solve(root);
//         System.out.println(ans.msp);
// 	}
	
// 	public Pair solve(TreeNode root) {
// 		if(root==null) return new Pair(0,Integer.MIN_VALUE);
		
// 		Pair left = solve(root.left);
// 		Pair right = solve(root.right);
// 		int op1 = root.val + left.ntr + right.ntr; //15 _ 20 + 7
// 		int op2 = left.msp; // 15
// 		int op3 = right.msp;  // 7
// 		return new Pair(Math.max(root.val+left.ntr, root.val+right.ntr),Math.max(op1,Math.max(op2, op3)));
// 	}
	
// 	static class Pair{
// 		int ntr;
// 		int msp;
// 		Pair(int ntr , int msp){
// 			this.ntr = ntr;
// 			this.msp = msp;
// 		}
// 	}

// }


