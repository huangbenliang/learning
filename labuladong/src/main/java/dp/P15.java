package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class P15 {

	private List<List<Integer>> res;

	public List<List<Integer>> threeSum(int[] nums) {
		res=threeSumTarget(nums, 0);
		return res;
	}

	private List<List<Integer>> threeSumTarget(int[] nums, int target) {
		Arrays.sort(nums);
		res=new ArrayList<>();
		for (int i = 0; i < nums.length; ) {
			int left = nums[i];
			List<List<Integer>> twoSum = twoSumTarget(nums, i + 1, target - nums[i]);
			for (List<Integer> integers : twoSum) {
				integers.add(nums[i]);
				res.add(integers);
			}
			while (i < nums.length && nums[i] == left) i++;
		}
		return res;
	}

	private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
		int lo = start, hi = nums.length - 1;
		ArrayList<List<Integer>> res = new ArrayList<>();
		while (lo < hi) {
			int sum = nums[lo] + nums[hi];
			int left = nums[lo], right = nums[hi];
			if (sum == target) {
				res.add(Arrays.stream(new int[]{left,right}).boxed().collect(Collectors.toList()));
				while (lo < hi && nums[lo] == left) lo++;
				while (lo < hi && nums[hi] == right) hi--;
			} else if (sum < target) {
				while (lo < hi && nums[lo] == left) lo++;
			} else {
				while (lo < hi && nums[hi] == right) hi--;
			}
		}
		return res;
	}
}