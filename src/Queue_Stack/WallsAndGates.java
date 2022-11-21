package Queue_Stack;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void wallsAndGates(int[][] rooms) {
        if(rooms==null) return;
        int row = rooms.length;
        int col = rooms[0].length;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<int[]>();
       // Set<Boolean[][]> visited = new HashSet<Boolean[][]>();
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(rooms[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                   // visited
                }
            }
        }
        
        int step = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] curr = queue.poll();
                for(int[] direction : directions) {
                    int x = curr[0] + direction[0];
                    int y = curr[1] + direction[1];
                    if(x>=0 && x<row && y>=0 && y<col && rooms[x][y]==2147483647) {
                        queue.offer(new int[] {x,y});
                        rooms[x][y] = step;
                    }
                }
            }
            step++;
        }
    }

}
