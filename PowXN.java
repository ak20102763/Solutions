class Solution {
    public double myPow(double x, int n) {
        int p = Math.abs(n);
        double res = 1.0;
	    while (p > 0)
	    {
	        int lastBit = (p & 1);
	        if (lastBit > 0) res = res * x;
	        x = x * x;
	        p = p >> 1;
	    }
        if(x>1 && n<0 && res==1.0) return 0;
        if(n<0) return 1/res;
        return res;
    }
}