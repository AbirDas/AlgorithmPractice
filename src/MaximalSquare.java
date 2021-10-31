
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix == null) return 0;
        int answer = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        for(int i=matrix.length -1; i>=0; i--) {
            for(int j=matrix[0].length -1; j>=0; j--) {
                if(i==matrix.length -1 && j==matrix[0].length -1 ){
                    dp[i][j] = matrix[i][j]-'0';
                }else if(i==matrix.length -1){
                    dp[i][j] = matrix[i][j]-'0';
                }else if(j==matrix[0].length -1){
                    dp[i][j] = matrix[i][j]-'0';
                }else{
                    if(matrix[i][j]=='0'){
                      dp[i][j] = matrix[i][j]-'0';  
                    }else{
                        int min = Math.min(dp[i][j+1],dp[i+1][j]);
                        min = Math.min(min,dp[i+1][j+1]);
                        dp[i][j] = min+1;
                    }
                }
                
                if(dp[i][j]>answer){
                    answer = dp[i][j];
                }
            }
        }
        
        return answer*answer;
    }
}
