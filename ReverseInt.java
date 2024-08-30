class Solution {
    public int reverse(int x) {
        int res = x;
		x = Math.abs(x);
		int  rem = 0, er=0;
		while (x!=0) {
			rem = x % 10;
			if(Integer.MIN_VALUE/10<=er && er<=Integer.MAX_VALUE/10) {
				er = er*10 + rem;
				x /= 10;
			}else {
				return 0;
			}	
		}
		if (res < 0)  return ~(er-1);
                else          return er;
    }
}