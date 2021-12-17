package Array;

public class MaximalRectangle {

	public static void main(String[] args) {

	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null)
			return 0;
		int iLen = matrix.length;
		int jLen = matrix[0].length;
		int max = 0;
		int[] value = new int[jLen];

		for (int i = 0, j = 0; j < jLen; j++) {
			value[j] = (int) (matrix[i][j] - '0');
		}
		max = LargestRectangle(value);

		for (int i = 1; i < iLen; i++) {
			for (int j = 0; j < jLen; j++) {
				if (matrix[i][j] == '1') {
					value[j] = value[j] + 1;
				} else {
					value[j] = 0;
				}
			}
			max = Math.max(max, LargestRectangle(value));
		}
		return max;
	}

	public int LargestRectangle(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;
		int len = arr.length;
		int max = 0;
		int[] leftless = new int[len];
		int[] rightless = new int[len];
		leftless[0] = -1;
		rightless[len - 1] = len;

		for (int i = 1; i < len; i++) {
			int pos = i - 1;
			while (pos >= 0 && arr[pos] >= arr[i]) {
				pos = leftless[pos];
			}
			leftless[i] = pos;
		}

		for (int i = len - 2; i >= 0; i--) {
			int pos = i + 1;
			while (pos < len && arr[pos] >= arr[i]) {
				pos = rightless[pos];
			}
			rightless[i] = pos;
		}

		for (int i = 0; i < len; i++) {
			int width = rightless[i] - leftless[i] - 1;
			int height = arr[i] * width;
			if (height > max)
				max = height;
		}
		return max;
	}

}
