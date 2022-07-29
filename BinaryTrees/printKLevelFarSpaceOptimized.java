package BinaryTrees;

import java.util.*;

public class printKLevelFarSpaceOptimized {
	List<Integer> ans;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		ans = new ArrayList<>();
		find(root, target, k);
		return ans;
	}

	public int find(TreeNode root, TreeNode target, int k) {
		if (root == null || k < 0) {
			return -1;
		}
		if (root.val == target.val) {
			printKDown(root, k, null);
			return +1;
		}
		int left = find(root.left, target, k);
		if (left != -1) {
			printKDown(root, k - left, root.left);
			return left + 1;
		}

		int right = find(root.right, target, k);
		if (right != -1) {
			printKDown(root, k - right, root.right);
			return right + 1;
		}
		return -1;
	}

	public void printKDown(TreeNode root, int k, TreeNode blocker) {
		if (root == null || k < 0 || root == blocker) {
			return;
		}
		if (k == 0)
			ans.add(root.val);
		printKDown(root.left, k - 1, blocker);
		printKDown(root.right, k - 1, blocker);
		return;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
