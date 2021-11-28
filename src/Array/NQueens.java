package Array;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		
	}

    List<List<String>> answer = new ArrayList<List<String>>();
    int len = 0;
    public List<List<String>> solveNQueens(int n) {
        if(n==0) return answer;
        len = n;
        int[][] ches = new int[n][n];
        dfs(ches,0);
        return answer;
    }
    
    public void dfs(int[][] ches, int col) {
        if(col == len) {
            addPossibleAnswer(ches);
            return;
        }
        
        for(int row=0; row<len; row++) {
            if(isValidPlace(ches,col,row)) {
                ches[col][row] = 1;
                dfs(ches,col+1);
                ches[col][row]= 0;
            }
        }
    }
    
    public boolean isValidPlace(int[][] ches, int col,  int row) {
        for(int i=col-1,j=row; i>=0; i--) {
            if(ches[i][j]==1) return false;
        }
        
        for(int i=col-1,j=row-1; i>=0 && j>=0; i--,j--) {
            if(ches[i][j]==1) return false;
        }
        
        for(int i=col-1,j=row+1; i>=0 && j<len; i--,j++) {
            if(ches[i][j]==1) return false;
        }
        
        return true;
    }
    
    public void addPossibleAnswer(int[][] ches) {
        List<String> innerAnswer = new ArrayList<String>();
        for(int i=0; i<len; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<len; j++) {
                if(ches[i][j] == 1) {
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            innerAnswer.add(sb.toString());
        }
        answer.add(innerAnswer);
    }
}
