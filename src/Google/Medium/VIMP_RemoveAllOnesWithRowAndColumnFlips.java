package Google.Medium;

public class VIMP_RemoveAllOnesWithRowAndColumnFlips {

	public static void main(String[] args) {
		/*
		Input: grid = [[0,1,0],[1,0,1],[0,1,0]]
		Output: true
		Explanation: One possible way to remove all 1's from grid is to:
		- Flip the middle row
		- Flip the middle column
		*/
		int[][] arr = {{0,1,0},{1,0,1},{0,1,0}};
		System.out.println(removeOnes(arr));
	}

	public static boolean removeOnes(int[][] grid) {
		if (grid == null)
			return false;
		int row = grid.length;
		int col = grid[0].length;
		if (row == 0 || col == 0)
			return false;
		if (row == 1 && col == 1)
			return true;

		int[] parten = new int[col];
		int[] reverse = new int[col];

		for (int i = 0; i < col; i++) {
			int temp = grid[0][i];
			parten[i] = temp;
			reverse[i] = temp == 1 ? 0 : 1;
		}

		for (int[] arr : grid) {
			if (!match(arr, parten) && !match(arr, reverse))
				return false;
		}
		return true;
	}

	private static boolean match(int[] grid, int[] parten) {
		for (int i = 0; i < grid.length; i++) {
			if (grid[i] != parten[i])
				return false;
		}
		return true;
	}

	
	
	/********************************************************************************/
	 /*for(int i=0; i<row; i++) {
         if(grid[i][0]==1){
             for(int j=0; j<col; j++) {
                 grid[i][j] = grid[i][j]==1 ? 0 : 1;
             }
         }
     }
     
     for(int i=1; i<row; i++) {
         for(int j=0; j<col; j++) {
             if(grid[i][j]!=grid[i-1][j]) return false;
         }
     }
     return true;*/
}
