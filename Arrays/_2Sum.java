package Arrays;

import java.util.*;

public class _2Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// T.C : O(nlogn) // O(n) approach be found on leetcode,
		// S.C : O(1)
		// Will only work for sorted arrays.
	}

	public List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
		int i = start;
		int j = end;
		List<List<Integer>> res = new ArrayList<>();
		while (i < j) {
			int sum = nums[i] + nums[j];
			if (i != start && nums[i] == nums[i - 1]) {
				// something
				i++;
				continue;
			}
			if (sum == target) {
				List<Integer> temp = new ArrayList<>();
				temp.add(nums[i]);
				temp.add(nums[j]);
				res.add(temp);
				i++;
				j--;
			} else if (sum > target) {
				j--;
			} else {
				i++;
			}
		}
		return res;
	}

}
