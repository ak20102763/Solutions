class Solution {
    public boolean isValidSudoku(char[][] board) {
		Set<Character> hashSet = new HashSet<Character>();
		
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (hashSet.contains(board[i][j])) return false;
                hashSet.add(board[i][j]);
            }
            hashSet.clear();
        }
    
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                if (hashSet.contains(board[j][i])) return false;
                hashSet.add(board[j][i]);
            }
            hashSet.clear();
        }
        
        for (int k = 0; k < 9; k++) {
            for (int i = k/3*3; i < k/3*3+3; i++) {
                for (int j = (k%3)*3; j < (k%3)*3+3; j++) {
                    if (board[i][j] == '.') continue;
                    if (hashSet.contains(board[i][j])) return false;
                        hashSet.add(board[i][j]);
                }
            }
            hashSet.clear();
        }
        return true;

	}
}