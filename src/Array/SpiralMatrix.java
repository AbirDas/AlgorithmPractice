package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> answer = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return answer;

		int iLen = matrix.length;
		int jLen = matrix[0].length;
		int direction = 0;

		int left = 0;
		int right = jLen - 1;
		int top = 0;
		int bottom = iLen - 1;

		while (answer.size() < (iLen * jLen)) {

			if (direction == 0) {
				for (int i = left; i <= right; i++) {
					answer.add(matrix[top][i]);
				}
				top++;
			} else if (direction == 1) {
				for (int i = top; i <= bottom; i++) {
					answer.add(matrix[i][right]);
				}
				right--;
			} else if (direction == 2) {
				for (int i = right; i >= left; i--) {
					answer.add(matrix[bottom][i]);
				}
				bottom--;
			} else if (direction == 3) {
				for (int i = bottom; i >= top; i--) {
					answer.add(matrix[i][left]);
				}
				left++;
			}

			direction = (direction + 1) % 4;
		}
		return answer;
	}

}
