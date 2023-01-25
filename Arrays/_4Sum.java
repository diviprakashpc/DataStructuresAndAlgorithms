package Arrays;

import java.util.*;

public class _4Sum {
	// TC O(n^3)
	// SC O(1)
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int first = nums[i];
			List<List<Integer>> sub_res = threeSum(nums, i + 1, n - 1, target - first);
			for (List l : sub_res) {
				l.add(first);
				res.add(l);
			}
		}
		return res;
	}

	public List<List<Integer>> threeSum(int[] nums, int start, int end, long target) {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			if (i != start && nums[i] == nums[i - 1])
				continue;
			int first = nums[i];
			List<List<Integer>> sub_res = twoSum(nums, i + 1, n - 1, target - first);
			for (List l : sub_res) {
				l.add(first);
				res.add(l);
			}
		}
		return res;
	}

	public List<List<Integer>> twoSum(int[] nums, int start, int end, long target) {
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
