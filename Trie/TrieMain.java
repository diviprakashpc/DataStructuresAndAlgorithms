package Trie;

public class TrieMain {
	public static void main(String[] args) {
		Trie root = new Trie();
		root.add("note");
		System.out.println(root.search("note"));

	}
}
