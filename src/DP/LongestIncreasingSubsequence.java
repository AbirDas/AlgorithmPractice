package DP;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
	}

    public static int lengthOfLIS(int[] nums) {
        if(nums==null) return 0;
        int len = nums.length;
        if(len==1) return 1;
        int answer = 0;
        
        int[] dp = new int[len];
        dp[0] = 1;
        
        for(int i=1; i<len; i++){
            int max = 0;
            
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    if(dp[j]>max) {
                        max = dp[j]; 
                    }
                }
            }
            dp[i] = max+1;
            if(dp[i]>answer) {
               answer = dp[i]; 
            } 
        }
        return answer;
    }
	
}
