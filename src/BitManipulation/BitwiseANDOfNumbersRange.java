package BitManipulation;

public class BitwiseANDOfNumbersRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rangeBitwiseAnd(int left, int right) {
		int result = 0;

		while (left < right) {
			left = left >> 1;
			right = right >> 1;
			result++;
		}
		return right << result;
	}

	public int rangeBitwiseAnd_BrianKernighanAlgorithm(int left, int right) {
		while (left < right) {
			right = right & (right - 1);
		}
		return left & right;
	}

}
