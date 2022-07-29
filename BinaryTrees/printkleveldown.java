package BinaryTrees;

public class printkleveldown {
    public void printkleveldown(Node root , int k) {
    	if(root==null||k<0) return;
    	if(k==0) {
    		System.out.println(root.value);
    	}
    	
    	printkleveldown(root.left, k-1);
    	printkleveldown(root.right,k-1);
    	
    } 
    class Node{
    	int value;
    	Node left;
    	Node right;
    	Node(int value){
    		this.value = value;
    		this.left = null;
    		this.right = null;
    	}
    }
}



