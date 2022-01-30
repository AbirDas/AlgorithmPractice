package Google.Hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IMP_MinimumCostToMakeAtLeastOneValidPathInAGrid {

	public static void main(String[] args) {
		/*
		Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
		Output: 3
		Explanation: You will start at point (0, 0).
		The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
		The total cost = 3.
		*/
		int[][] grid = {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
		System.out.println(minCost(grid));
	}
	
    //direction
    //1-right, 2-left, 3-down, 4-up
    static int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public static int minCost(int[][] grid) {
        if(grid==null) return 0;
        int row=grid.length, coll=grid[0].length;
        if(row==1 && coll==1) return 0;
        
        int[][] costs = new int[row][coll];
        for(int[] cost : costs) {
            Arrays.fill(cost,-1);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        dfs(grid,0,0,costs,0,queue);
        
        while(!queue.isEmpty()) {
            
            if(costs[row-1][coll-1]!=-1) {
                return costs[row-1][coll-1];
            }
            
            int[] qDir = queue.poll();
            for(int[] dir : direction) {
                dfs(grid,qDir[0]+dir[0],qDir[1]+dir[1],costs,costs[qDir[0]][qDir[1]]+1,queue);
            }
        }
        return -1;
    }
    
    private static void dfs(int[][] grid, int row, int coll, int[][] costs, int currCost, Queue<int[]> queue) {
        if(row<0 || row>=grid.length || coll<0 || coll>=grid[0].length || costs[row][coll]!=-1) {
            return;
        }
        
        costs[row][coll] = currCost;
        queue.offer(new int[]{row,coll});
        
        int[] dir = direction[grid[row][coll]-1];
        dfs(grid,row+dir[0],coll+dir[1],costs,currCost,queue);
    }

}
