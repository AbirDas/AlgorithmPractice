package DP;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("mississippi","mis*is*.p*."));
	}

	    public static boolean isMatch(String s, String p) {
	        int sLen = s.length();
	        int pLen = p.length();
	        boolean[][] dp = new boolean[pLen+1][sLen+1];
	        
	        for(int i=0; i<=pLen; i++) {
	            for(int j=0; j<=sLen; j++) {
	                
	                if(i==0 && j==0) {
	                    dp[i][j] = true;
	                }else if(i==0) {
	                    dp[i][j] = false;
	                }else if(j==0) {
	                    if(p.charAt(i-1)=='*') {
	                        dp[i][j] = dp[i-2][j];
	                    }else{
	                        dp[i][j] = false;
	                    }
	                }else{
	                    char pc = p.charAt(i-1);
	                    char sc = s.charAt(j-1);
	                    
	                    if(pc=='*') {
	                        dp[i][j] = dp[i-2][j];
	                        char pcls = p.charAt(i-2);
	                        if(pcls=='.' || pcls==sc) {
	                            dp[i][j] = dp[i][j] || dp[i][j-1];
	                        }
	                    }else if(pc=='.') {
	                        dp[i][j] = dp[i-1][j-1];
	                    }else if(pc==sc) {
	                        dp[i][j] = dp[i-1][j-1];
	                    }else{
	                        dp[i][j] = false;
	                    }
	                }
	            }
	        }
	        return dp[pLen][sLen];
	    }
}
