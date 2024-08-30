class Solution {

    List<List<String>> res = new ArrayList<List<String>>();

	public List<List<String>> solveNQueens(int n) {

		var queenPositions = new int[n];
		Arrays.fill(queenPositions, -18);

		placeInNextRow(queenPositions, 0, n);

		return res;
	}

	public void placeInNextRow(int[] queenPositions, int i, int n) {

		if(i==n) {
			var board = new ArrayList<String>();
			for(int q: queenPositions) {
				char[] chars = new char[n];
				Arrays.fill(chars, '.');
				chars[q] = 'Q';
				var res = new String(chars);
				board.add(res);
			}
			res.add(board);
		}
		for(int j=0;j<n;j++) {
			if(isValid(queenPositions, i, j)) {
				queenPositions[i] = j;
				placeInNextRow(queenPositions, i+1, n);
				queenPositions[i] = -18;                 // remove queen and try next position
			}
		}
	}
	
	public boolean isValid(int[] arr, int i, int j) {
		
		for(int k=0;k<i;k++) {
			if(arr[k]==j || arr[k]-k==j-i || arr[k]+k==j+i) return false;
		}
		
		return true;
	}
}