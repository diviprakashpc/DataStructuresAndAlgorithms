package BinaryTrees;
import java.util.*;
public class PathSum_II {
	private List<List<Integer>> ans = new ArrayList<>();
	private static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val, TreeNode left, TreeNode right) {
			super();
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
	}
	
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         List<Integer> psf = new ArrayList<>(); //path so far
        hasPath(root,targetSum,psf);
        return ans;
    }
    
    public void hasPath(TreeNode root , int sum,List<Integer> psf){
        if(root==null) return;
        psf.add(root.val);
        if(root.left==null&&root.right==null&&sum==root.val) {
            ans.add(new ArrayList<>(psf));
            psf.remove(psf.size()-1);
            return;
        }
        
        hasPath(root.left,sum-root.val,psf);
        hasPath(root.right,sum-root.val,psf);
        psf.remove(psf.size()-1);
        return;
    }

}
