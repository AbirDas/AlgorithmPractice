package Google.Medium;

public class IMP_MaximumNumberOfPointsWithCost {

	public static void main(String[] args) {
		int[][] points = {{1,2,3},{1,5,1},{3,1,1}};
		System.out.println(maxPoints(points));
	}

	public static long maxPoints(int[][] points) {
		if (points == null)
			return 0;

		int rows = points.length;
		int cols = points[0].length;
		Long[][] dp = new Long[rows][cols];

		for (int i = 0; i < cols; i++) {
			dp[0][i] = Long.valueOf(points[0][i]);
		}

		Long[] left = new Long[cols];
		Long[] right = new Long[cols];
		for (int i = 1; i < rows; i++) {

			left[0] = dp[i - 1][0];
			for (int j = 1; j < cols; j++) {
				left[j] = Math.max(left[j - 1] - 1, dp[i - 1][j]);
			}

			right[cols - 1] = dp[i - 1][cols - 1];
			for (int j = cols - 2; j >= 0; j--) {
				right[j] = Math.max(right[j + 1] - 1, dp[i - 1][j]);
			}

			for (int j = 0; j < cols; j++) {
				dp[i][j] = Math.max(left[j], right[j]) + points[i][j];
			}
		}

		long max = Long.valueOf(-1);
		for (int i = 0; i < cols; i++) {
			max = Math.max(max, dp[rows - 1][i]);
		}
		return max;
	}

}
