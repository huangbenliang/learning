package dp;

import org.junit.jupiter.api.Test;

class P518 {
	int sum;
	int res;
	int amount;

	public int change(int amount, int[] coins) {
		this.amount = amount;
		backtrack(coins, 0);

		return res;
	}

	private void backtrack(int[] coins, int start) {
		if (sum == amount) {
			res++;
			return;
		} else if (sum > amount) {
			return;
		}
		for (int i = start; i < coins.length; i++) {
			sum += coins[i];
			backtrack(coins, i);
			sum -= coins[i];
		}
	}

	public int change1(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] += dp[i - coin];
			}
		}
		return dp[amount];
	}


	@Test
	public void test() {
		int res = change1(500, new int[]{3, 5, 7, 8, 9, 10, 11});
		System.out.println("res = " + res);
	}
}