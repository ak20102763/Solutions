class Solution {
    List<List<Integer>> ls = new ArrayList<List<Integer>>();
	List<Integer> l = new ArrayList<Integer>();

	public List<List<Integer>> permute(int[] nums) {

		permute(0, nums);
		return ls;
	}

	public void permute(int i, int[] ar) {

		if (i == ar.length) {
			for (int num : ar) l.add(num);
			ls.add(new ArrayList<Integer>(l));
			l.clear();

                        return;

		} else {
			for (int j = i; j < ar.length; j++) {
				swap(ar, i, j);
				permute(i + 1, ar);
				swap(ar, i, j);
			}
		}

	}

	public void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}
}