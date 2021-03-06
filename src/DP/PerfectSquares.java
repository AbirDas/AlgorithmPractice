package DP;

public class PerfectSquares {

	public static void main(String[] args) {
		System.out.println(numSquares(4));
	}
	
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=1; (j*j)<=i; j++) {
                
                int pos = i - (j*j);
                if(dp[pos]<min) {
                    min = dp[pos];
                }
            }
            dp[i] = min+1;
        }
        return dp[n];
    }
}
