class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] b = new boolean[nums.length+1];
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0 && nums[i]<=nums.length) {
				b[nums[i]] = true;
				max = Math.max(max, nums[i]);
			}
		}
		
		for(int j=1;j<b.length;j++) {
			if(!b[j]) {
				return j;
			}
		}

		return max + 1;
	}
}