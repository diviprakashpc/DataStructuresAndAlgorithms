package Parition_Dp;

import java.util.*;
//Question link :https://leetcode.com/problems/different-ways-to-add-parentheses/

class DifferentWaysToAddParentheses {
	public List<Integer> diffWaysToCompute(String expression) {
		if (expression.length() == 0)
			return new ArrayList<>();
		if (expression.length() == 1) {
			List<Integer> temp = new ArrayList<>();
			temp.add(expression.charAt(0) - '0');
			return temp;
		}
		boolean flag = false; // Because aise bhi test cases hai jisme there are no operators.
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < expression.length(); i++) { // partition ka loop
			char ch = expression.charAt(i);
			if (ch == '*' || ch == '-' || ch == '+') { // jab bhi operator mil rha partition krke left aur right dekh
														// rahe.
				flag = true;
				List<Integer> left = diffWaysToCompute(expression.substring(0, i));
				List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
				for (Integer x : left) {
					for (Integer y : right) {
						ans.add(evaluate(x, y, ch));
					}
				}
			}
		}
		if (!flag)
			ans.add(Integer.parseInt(expression)); // When no operator is present
		return ans;
	}

	public int evaluate(int x, int y, Character op) {
		if (op == '*') {
			return x * y;
		} else if (op == '+') {
			return x + y;
		} else {
			return x - y;
		}
	}
}