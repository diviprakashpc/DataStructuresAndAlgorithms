package Sliding_Window;

import java.util.*;

public class countOccurencesOfAnagrams {

	/*
	 * Given a word pat and a text txt. Return the count of the occurences of
	 * anagrams of the word in the text.
	 * 
	 * An anagram of a string is another string that contains the same characters,
	 * only the order of characters can be different. For example, “abcd” and “dabc”
	 * are an anagram of each other.
	 * 
	 * Example 1:
	 * 
	 * Input: txt = forxxorfxdofr pat = for Output: 3 Explanation: for, orf and ofr
	 * appears in the txt, hence answer is 3.
	 */

	/*
	 * Why sliding window? The anagram would always appear in continuous form and
	 * its size will always be same as that of pattern . Therfore a window =
	 * pat.length() and a mention of substring. Hence, Sliding window question.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int countOccurencesOfAnagrams(String txt, String pat) {
		int count = 0;
		int k = pat.length();
		int unique = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int i = 0;
		int j = 0;
		for (int itr = 0; itr < pat.length(); itr++) {
			map.put(pat.charAt(itr), map.getOrDefault(pat.charAt(itr), 0) + 1);

		}
		unique = map.size();
		while (j < txt.length()) {
			if (map.containsKey(txt.charAt(j))) {
				map.put(txt.charAt(j), map.getOrDefault(txt.charAt(j), 0) - 1);
				if (map.get(txt.charAt(j)) == 0)
					unique--;
			}
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (unique == 0)
					count++;
				if (map.containsKey(txt.charAt(i))) {
					map.put(txt.charAt(i), map.getOrDefault(txt.charAt(i), 0) + 1);
					if (map.get(txt.charAt(i)) == 1)
						unique++;

				}
				i++;
				j++;
			}
		}
		return count;
	}

}
