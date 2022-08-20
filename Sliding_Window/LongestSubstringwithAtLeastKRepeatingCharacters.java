package Sliding_Window;

import java.util.*;

/*Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.*/
public class LongestSubstringwithAtLeastKRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestSubstring(String s, int k) {
		//T.C O(n^2)
		if (s.length() < k)
			return 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.get(ch) >= k)
				continue;
			else {
				int left = longestSubstring(s.substring(0, i), k);
				int right = longestSubstring(s.substring(i + 1), k);
				return Math.max(left, right);
			}
		}
		return s.length();

	}

}
