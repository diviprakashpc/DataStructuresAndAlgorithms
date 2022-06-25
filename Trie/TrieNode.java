package Trie;

public class TrieNode {
    char ch;
    boolean isTerminating;
    TrieNode[] children;
    int childCount;
    
    public TrieNode(char ch) {
    	this.ch = ch;
    	isTerminating = false;
    	children = new TrieNode[26];
    	childCount = 0;
    }
}
