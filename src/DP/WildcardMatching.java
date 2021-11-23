package DP;

public class WildcardMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("adceb","*a*b"));
	}
	
    public static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[pLen+1][sLen+1];
        
        for(int i=pLen; i>=0; i--) {
            for(int j=sLen; j>=0; j--) {
                if(i==pLen && j==sLen) {
                    dp[i][j] = true;
                }else if(i==pLen) {
                    dp[i][j] = false;
                }else if(j==sLen) {
                    if(p.charAt(i)=='*') {
                        dp[i][j] = dp[i+1][j];
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    
                    if(p.charAt(i)=='?') {
                        dp[i][j] = dp[i+1][j+1];
                    }else if(p.charAt(i)=='*') {
                        dp[i][j] = dp[i+1][j] || dp[i][j+1];
                    } else if(p.charAt(i)==s.charAt(j)) {
                        dp[i][j] = dp[i+1][j+1];
                    }else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[0][0];
    }

}
