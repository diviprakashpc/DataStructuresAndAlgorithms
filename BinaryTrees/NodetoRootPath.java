package BinaryTrees;
import java.util.*;
import BinaryTrees.printkleveldown.Node;

public class NodetoRootPath {
  //5 hissey code ke
	static List<Node> nodetorootpath;
	
	NodetoRootPath(){
		nodetorootpath = new ArrayList<>();
	}
	public static boolean NodetoRootPath(Node node, int data) {
		if(node==null) {
			return false;
		}
		if(node.value==data) {
			nodetorootpath.add(node);
			return true;
		}
		
		if(NodetoRootPath(node.left, data)) {
			nodetorootpath.add(node);
			return true;
		}
		if(NodetoRootPath(node.right, data)) {
			nodetorootpath.add(node);
			return true;
		}
		
		return false;
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
