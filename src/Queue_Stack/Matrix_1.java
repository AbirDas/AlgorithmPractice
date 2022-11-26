package Queue_Stack;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix_1 m = new Matrix_1();
		int[][] que = {{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}};
		int[][] ans = m.updateMatrix_DFS(que);
		
		for(int i=0; i<ans.length; i++) {
			for(int j=0; j<ans[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public int[][] updateMatrix_DFS(int[][] mat) {
        if(mat==null) return new int[0][0];
        
        int rowLen = mat.length;
        int colLen = mat[0].length;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[rowLen][colLen];
        Queue<int[]> queue = new LinkedList<int[]>();
        
        for(int i=0; i<rowLen; i++) {
            for(int j=0; j<colLen; j++) {
                if(mat[i][j]==0 && !visited[i][j]) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }                
            }
        }
        
        int step = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] curr = queue.poll();
                for(int[] direction : directions) {
                    int row = curr[0] + direction[0];
                    int col = curr[1] + direction[1];
                    
                    if(row>=0 && row<rowLen && col>=0 && col<colLen && !visited[row][col]) {
                        visited[row][col] = true;
                        mat[row][col] = step;
                        queue.offer(new int[]{row,col});
                    }
                }
            }
            step++;
        }
        return mat;
    }
	
	
	//more efficient
	public int[][] updateMatrix_DP(int[][] mat) {
        if(mat==null) return new int[0][0];
        
        int rowLen = mat.length;
        int colLen = mat[0].length;
        int max = rowLen+colLen;
        
        //execution top-bottom, looking top and left
        for(int i=0; i<rowLen; i++) {
            for(int j=0; j<colLen; j++) {
                int top=max,left=max;
                if(mat[i][j]!=0) {
                    if((i-1)>=0) top = mat[i-1][j];
                    if((j-1)>=0) left = mat[i][j-1];
                    mat[i][j] = Math.min(top,left) + 1;
                }
            }
        }
        
        //Execution bottom-top, looking down and right
        for(int i=rowLen-1; i>=0; i--) {
            for(int j=colLen-1; j>=0; j--) {
                int bottom=max,right=max;
                if(mat[i][j]!=0) {
                    if((i+1)<rowLen) bottom= mat[i+1][j];
                    if((j+1)<colLen) right = mat[i][j+1];
                    mat[i][j] = Math.min(mat[i][j], Math.min(bottom,right)+1);
                }
            }
        }
        return mat;
    }

}
