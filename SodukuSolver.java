class Solution {
    public void solveSudoku(char[][] board) {

		solveNextCell(board);

	}

	public boolean solveNextCell(char[][] board) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char chr='1'; chr<='9'; chr++) {
						if (isValidSoduku(board, chr, i, j)) {
							board[i][j] = chr;
							if (solveNextCell(board))
								return true;
						}
						board[i][j] = '.';
					}
					return false;
				}
			}
		}

		return true;

	}

	public boolean isValidSoduku(char[][] board, char chr, int i, int j) {

		for (int k = 0; k < 9; k++) {
			if (board[i][k] == chr || board[k][j] == chr) return false;
		}

		for (int l = (i / 3) * 3; l < (i / 3) * 3 + 3; l++) {
			for (int m = (j / 3) * 3; m < (j / 3) * 3 + 3; m++) {
				if (board[l][m] == chr)
					return false;
			}
		}

		return true;
	}
}