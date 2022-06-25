package Trie;

public class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode('/');
	}

	public void add(String word) {
		add(root, word);
	}

	private void add(TrieNode root, String word) {
		if (word.length() == 0) {
			root.isTerminating = true;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(root.children[childIndex], word.substring(1));
	}

	public void delete(String word) {
		delete(root, word);
	}

	private void delete(TrieNode root, String word) {
		if (word.length() == 0) {
			root.isTerminating = false;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) {
			return;
		}
		delete(child, word.substring(1));
		if (!child.isTerminating && child.childCount == 0) {
			root.children[childIndex] = null;
			root.childCount--;
		}

	}

	public boolean search(String word) {
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if (word.length() == 0) {
			return root.isTerminating;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null)
			return false;
		boolean sa = search(child, word.substring(1));
		return sa;
	}
}
