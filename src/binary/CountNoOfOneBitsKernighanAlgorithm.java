package binary;

public class CountNoOfOneBitsKernighanAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = 5;
		System.out.println(kernighanAlgorithm(ans));
		System.out.println(Integer.bitCount(ans));
		System.out.println(Integer.toBinaryString(ans));
	}

	public static int kernighanAlgorithm(int num) {
		int count = 0;
		while(num!=0) {
			int rmsb = num & -num; //right most set bit
			num = num - rmsb;
			//num = num & (num-1);
			count++;
		}
		return count;
	}
}
