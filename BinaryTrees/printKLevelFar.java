package BinaryTrees;
import java.util.*;
//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
import BinaryTrees.NodetoRootPath.Node;
public class printKLevelFar {
     static List<Node> path = new ArrayList<>();
	
     public void printKLevelFar(Node root, Node target , int k) {
        NodetoRootPath(root,target.value);
        
        for(int i = 0 ; i < path.size()&&i<=k ; i++) {
        	printkleveldown(path.get(i),k-i,i==0?null:path.get(i-1));
        }
        
	}
     
     public static boolean NodetoRootPath(Node node, int data) {
 		if(node==null) {
 			return false;
 		}
 		if(node.value==data) {
 			path.add(node);
 			return true;
 		}
 		
 		if(NodetoRootPath(node.left, data)) {
 			path.add(node);
 			return true;
 		}
 		if(NodetoRootPath(node.right, data)) {
 			path.add(node);
 			return true;
 		}
 		
 		return false;
 	}
     
     public void printkleveldown(Node root , int k,Node blocker) {
     	if(root==null||k<0||root==blocker) return;
     	if(k==0) {
     		System.out.println(root.value);
     	}
     	
     	printkleveldown(root.left, k-1,blocker);
     	printkleveldown(root.right,k-1,blocker);
     	
     } 
	 
	

	class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

}
