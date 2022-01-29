package Google.Medium;

public class LongestLineOfConsecutiveOneInMatrix {

	public static void main(String[] args) {
		/*
		Input: mat = [[0,1,1,0],[0,1,1,0],[0,0,0,1]]
		Output: 3
		*/
		int[][] mat = {{0,1,1,0},{0,1,1,0},{0,0,0,1}};
		System.out.println(longestLine(mat));
	}

	public static int longestLine(int[][] mat) {
		if (mat == null)
			return 0;
		int row = mat.length;
		int col = mat[0].length;
		if (row == 0 || col == 0)
			return 0;
		if (row == 1 && col == 1)
			return mat[0][0];

		int[][][] dp = new int[row][col][4];
		int ans = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat[i][j] == 1) {
					// hotizontal
					dp[i][j][0] = j > 0 ? dp[i][j - 1][0] + 1 : 1;
					// vertical
					dp[i][j][1] = i > 0 ? dp[i - 1][j][1] + 1 : 1;
					// diagonal
					dp[i][j][2] = (i > 0 && j > 0) ? dp[i - 1][j - 1][2] + 1 : 1;
					// anti-diagonal
					dp[i][j][3] = (i > 0 && j < col - 1) ? dp[i - 1][j + 1][3] + 1 : 1;

					ans = Math.max(ans, dp[i][j][0]);
					ans = Math.max(ans, dp[i][j][1]);
					ans = Math.max(ans, dp[i][j][2]);
					ans = Math.max(ans, dp[i][j][3]);
				}
			}
		}
		return ans;
	}

}
