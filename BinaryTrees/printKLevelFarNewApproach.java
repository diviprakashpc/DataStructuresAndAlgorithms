package BinaryTrees;

import java.util.*;
//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class printKLevelFarNewApproach {

	Map<TreeNode, TreeNode> parentMap;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		parentMap = new HashMap<>();
		fillParent(root);
		Set<TreeNode> vis = new HashSet<>();
		Queue<TreeNode> q = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		q.add(target);
		vis.add(target);
		while (!q.isEmpty() && k-- > 0) {
			int size = q.size();
			while (size-- > 0) {
				TreeNode rem = q.remove();
				if (rem.left != null && !vis.contains(rem.left)) {
					q.add(rem.left);
					vis.add(rem.left);
				}
				if (rem.right != null && !vis.contains(rem.right)) {
					q.add(rem.right);
					vis.add(rem.right);
				}
				if (parentMap.get(rem) != null && !vis.contains(parentMap.get(rem))) {
					q.add(parentMap.get(rem));
					vis.add(parentMap.get(rem));
				}
			}
		}

		for (TreeNode n : q)
			res.add(n.val);
		return res;
	}

	public void fillParent(TreeNode root) {
		fillParentHelper(root, null);
	}

	public void fillParentHelper(TreeNode root, TreeNode parent) {
		if (root == null)
			return;
		parentMap.put(root, parent);
		fillParentHelper(root.left, root);
		fillParentHelper(root.right, root);
	}
}
