class Solution {
    public boolean isMatch(String s, String p) {

		Boolean[][] res = new Boolean[p.length()][s.length()];
		
		return doMatch(res, s, p, s.length()-1, p.length()-1);
	}
	
	public boolean doMatch(Boolean[][] res, String s, String p, int i, int j) {
		
		if (i < 0 && j < 0) return true;	
		if (i >= 0 && j < 0) return false;
		if (i < 0 && j >= 0) {
			int c = 0;
			for(c=j; c>0; c-=2) if(p.charAt(c)!='*') return false;
			if(c<0) return true;
			return false;
		}
		
		if (res[j][i] != null)  return res[j][i];
		if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))  return res[j][i] = doMatch(res, s, p, i - 1, j - 1);
		if (p.charAt(j) == '*') {
			if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.')
				return res[j][i] = doMatch(res, s, p, i - 1, j) || doMatch(res, s, p, i, j-2);
			else  return res[j][i] = doMatch(res, s, p, i, j - 2);
		}
		return false;
	}
}