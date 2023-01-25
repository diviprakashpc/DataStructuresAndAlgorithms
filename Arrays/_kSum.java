package Arrays;

import java.util.*;

public class _kSum {

	public static void main(String[] args) {
          int[] nums = {10,20,30,40,50,10,20,50,60};
          int target = 100;
          int k  = 3;
          List<List<Integer>> ans = kSum(nums,target,k);
          System.out.println(ans);
          //TC O(n*k-1)
	}

	public static List<List<Integer>> kSum(int[] nums, int target, int k) {
		Arrays.sort(nums);
		return kSumHelper(nums, target, k, 0);
	}

	public static List<List<Integer>> twoSum(int[] nums, int target, int si) {
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		if (n - si < 2)
			return res;
		int left = si;
		int right = n - 1;
		while (left < right) {
			if (left != si && nums[left] == nums[left - 1]) {
				left++;
				continue;
			}
			int sum = nums[left] + nums[right];
			if (sum == target) {
				List<Integer> temp = new ArrayList<>();
				temp.add(nums[left]);
				temp.add(nums[right]);
				res.add(temp);
				left++;
				right--;
			} else if (sum > target)
				right--;
			else
				left++;
		}
		return res;
	}

	public static List<List<Integer>> kSumHelper(int[] nums, int target, int k, int si) {
		if (k == 2) {
			return twoSum(nums, target, si);
		}

		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		if (n - si < k) {
			return res;
		}

		for (int i = si; i <= n - k; i++) {
			if (i != si && nums[i] == nums[i - 1])
				continue;
			int val1 = nums[i];
			List<List<Integer>> sub_res = kSumHelper(nums, target - val1, k - 1, i + 1);
			for (List<Integer> l : sub_res) {
				l.add(val1);
				res.add(l);
			}
		}

		return res;
	}
}
