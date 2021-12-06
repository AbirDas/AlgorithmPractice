package Array;

public class ValidSudoku {

	public static void main(String[] args) {
		char[][] board = new char[][]{
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
			};
			System.out.println(isValidSudoku(board));
	}

	public static boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					if (validate(board, i, j, board[i][j]) == false) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static boolean validate(char[][] board, int i, int j, char val) {
		for (int k = 0; k < board.length; k++) {
			if (k == i)
				continue;
			if (board[k][j] == val)
				return false;
		}

		for (int k = 0; k < board[0].length; k++) {
			if (k == j)
				continue;
			if (board[i][k] == val)
				return false;
		}

		int a = 3 * (i / 3);
		int b = 3 * (j / 3);
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				if(((a+k)==i) && ((b+l)==j)) continue;
				if (board[a + k][b + l] == val)
					return false;
			}
		}
		return true;
	}

}
