package Arrays;

import java.util.*;

public class _3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// T.C O(n^2)
		// S.C O(1) {no space considering for answer list).
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			int first = nums[i];
			List<List<Integer>> sub_res = twoSum(nums, i + 1, n - 1, -first);
			for (List l : sub_res) {
				l.add(first);
				res.add(l);
			}
		}
		return res;
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
