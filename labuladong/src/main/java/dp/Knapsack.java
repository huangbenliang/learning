package dp;

public class Knapsack {
	int knapsack(int w, int n, int[] wt, int[] val) {
		int[][] dp = new int[n + 1][w + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (j - wt[i - 1] < 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
				}
			}
		}
		return dp[n][w];
	}
}
