package Google.Hard;

import java.util.LinkedList;
import java.util.Queue;

public class IMP_ShortestPathInAGridWithObstaclesElimination {

	public static void main(String[] args) {
		int[][] arr = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
		System.out.println(shortestPath(arr,1));
	}

	static int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static int shortestPath(int[][] grid, int k) {
		int row = grid.length;
		int coll = grid[0].length;

		int[][] obstacle = new int[row][coll];
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visit = new boolean[row][coll];
		queue.offer(new int[] { 0, 0, grid[0][0] });
		obstacle[0][0] = grid[0][0];
		int level = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] curr = queue.poll();

				if (curr[0] == row - 1 && curr[1] == coll - 1) {
					return level;
				}

				int currObstracle = curr[2];

				for (int j = 0; j < dir.length; j++) {
					int x = curr[0] + dir[j][0];
					int y = curr[1] + dir[j][1];

					if (!(x >= 0 && x < row && y >= 0 && y < coll))
						continue;

					int oldObstracle = obstacle[x][y];
					int newObstracle = currObstracle + grid[x][y];

					if (!visit[x][y] && newObstracle <= k) {
						visit[x][y] = true;
						queue.offer(new int[] { x, y, newObstracle });
						obstacle[x][y] = newObstracle;
					}

					if (newObstracle < oldObstracle && newObstracle <= k) {
						visit[x][y] = true;
						queue.offer(new int[] { x, y, newObstracle });
						obstacle[x][y] = newObstracle;
					}
				}
			}
			level++;
		}

		return -1;
	}

}
