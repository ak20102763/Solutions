class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
		Arrays.sort(nums2);
		int m = 0, l = 0;
		List<Integer> res = new ArrayList<Integer>();
		while (m < nums1.length && l < nums2.length) {
			if (m < nums1.length && l < nums2.length && nums1[m] < nums2[l]) {
				res.add(nums1[m]);
				m++;
			} else if (m < nums1.length && l < nums2.length && nums1[m] > nums2[l]) {
				res.add(nums2[l]);
				l++;
			} else if (m < nums1.length && l < nums2.length && nums1[m] == nums2[l]) {
				res.add(nums1[m]);
				res.add(nums2[l]);
				m++;
				l++;
			}
		}
		while (l < nums2.length) {
			res.add(nums2[l]);
			l++;
		}
		while (m < nums1.length) {
			res.add(nums1[m]);
			m++;
		}

		if (res.size() % 2 == 1) {
			return res.get(res.size() / 2);
		} else {
			return (res.get((res.size() / 2) - 1) + res.get(res.size() / 2)) / (double) 2;
		}
    }
}