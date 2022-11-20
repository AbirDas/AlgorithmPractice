package BitManipulation;

public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] countBits(int n) {
		if (n == 0)
			return new int[1];

		int[] ans = new int[n + 1];

		for (int j = 1; j <= n; j++) {
			int count = 0;
			int i = j;
			while (i != 0) {
				count++;
				i = i & (i - 1);
			}
			ans[j] = count;
		}
		return ans;
	}
	
	public int[] countBitsDP(int n) {
		if(n==0) return new int[1];
		
		int[] ans = new int[n+1];
		for(int i=1; i<=n; i++ ) {
			// x / 2 is x >> 1 and x % 2 is x & 1
			//ans[i] = ans[i/2] + (i%2);
			ans[i] = ans[i>>1] + (i&1);
		}
		
		return ans;
	}
}
