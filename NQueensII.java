class Solution {

    int res = 0;

    public int totalNQueens(int n) {

		var arr = new int[n];
		Arrays.fill(arr, -18);

		placeQueen(arr, 0, n);

		return res;
	}

	public void placeQueen(int[] arr, int i, int n) {

		if (i == n)  res++;

		for (int j = 0; j < n; j++) {
			if (isValidPos(arr, i, j)) {
				arr[i] = j;
				placeQueen(arr, i + 1, n);
				arr[i] = -18;
			}
		}
	}

	public boolean isValidPos(int[] arr, int i, int j) {

		for (int k = 0; k < i; k++) {
			if (arr[k] == j || arr[k] - k == j - i || arr[k] + k == j + i)  return false;
		}

		return true;
	}
}