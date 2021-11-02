package DP;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Knapsack k = new Knapsack();
		// System.out.println(k.findTargetSumWays(new int[]{1,1,1,1,1},3));
		System.out.println(k.findTargetSumWays(new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 1));
	}

	public int findTargetSumWays(int[] nums, int target) {
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		if (sum < target || (sum + target) % 2 != 0)
			return 0;

		//return findSubSetWithOneD(nums, Math.abs((sum + target) / 2));
		return findSubSetWithTwoD(nums, Math.abs((sum + target) / 2));
	}

	public int findSubSetWithTwoD(int[] nums, int positiveSum) {
		if (nums.length < 1)
			return 0;
		int dp[][] = new int[nums.length + 1][positiveSum + 1];

		dp[0][0] = 1;
		for (int i = 1; i <= nums.length; i++) {
			dp[i][0] = 1;
			for (int j = 0; j <= positiveSum; j++) {
				if (j - nums[i - 1] >= 0) {
					dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}

		return dp[nums.length][positiveSum];
	}

	public int findSubSetWithOneD(int[] nums, int positiveSum) {
		if (nums.length < 1)
			return 0;
		int dp[] = new int[positiveSum + 1];

		dp[0] = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = positiveSum; j >= 0; j--) {
				if (j - nums[i] >= 0) {
					dp[j] = dp[j] + dp[j - nums[i]];
				}
			}
		}

		return dp[positiveSum];
	}
}
