package dp;

import org.junit.jupiter.api.Test;

class P416 {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0) return false;

		boolean[][] dp = new boolean[nums.length + 1][sum + 1];
		for (int i = 0; i < nums.length + 1; i++) {
			dp[i][0] = true;
		}
		for (int i = 1; i < nums.length + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (j - nums[i - 1] >= 0) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
				} else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		System.out.println();
		return dp[nums.length][sum/2];
	}
	boolean canPartition1(int[] nums) {
		int sum = 0, n = nums.length;
		for (int num : nums) sum += num;
		if (sum % 2 != 0) return false;
		sum = sum / 2;
		boolean[] dp=new boolean[sum + 1];
		// base case
		dp[0] = true;
		for (int i = 0; i < n; i++)
			for (int j = sum; j >= 0; j--)
				if (j - nums[i] >= 0)
					dp[j] = dp[j] || dp[j - nums[i]];

		return dp[sum];
	}



	@Test
	public void test(){
		boolean res = canPartition1(new int[]{1,5,11,5});
		System.out.println("res = " + res);
	}
}