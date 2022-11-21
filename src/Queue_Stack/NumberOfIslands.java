package Queue_Stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int rowLen, colLen;
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        
        rowLen = grid.length;
        colLen = grid[0].length;
        int count = 0;
        //System.out.println("rowLen = "+rowLen+",colLen = "+colLen);
        Queue<int[]> queue = new LinkedList<int[]>();
        Boolean[][] visited = new Boolean[rowLen][colLen];
        
        for(int i=0; i<rowLen; i++) {
            Arrays.fill(visited[i], false);
        }
        
        for(int i=0; i<rowLen; i++) {
            for(int j=0; j<colLen; j++) {
                if(grid[i][j]=='1' && !visited[i][j]) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                    count++;
                    traversiland(queue,grid,visited);
                }
            }
        }
        return count;
    }
    
    private void traversiland(Queue<int[]> queue,char[][] grid, Boolean[][] visited) {
        int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] direction : directions) {
                int x = curr[0] + direction[0];
                int y = curr[1] + direction[1];
                //System.out.println("x = "+x+",y = "+y);
                if(x>=0 && x<rowLen && y>=0 && y<colLen && grid[x][y]=='1' && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        
    }

}
