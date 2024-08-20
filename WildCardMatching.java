class Solution {

	Boolean res[][];

    public boolean isMatch(String s, String p) {
        res = new Boolean[p.length()][s.length()];
        return match(s.length() - 1, p.length() - 1, s, p);
    }
    public boolean match( int i, int j, String s, String p){
        if(j < 0 && i < 0) return true;
        if(j < 0 && i >= 0) return false;
        if(i < 0 && j >= 0){
            for(int c = 0; c <= j; c++) if(p.charAt(c) != '*') return false;
            return true;
        }
        if(res[j][i] != null) return res[j][i];
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') return res[j][i] = match(i - 1, j - 1, s, p);
        if(p.charAt(j) == '*') return res[j][i] = match(i, j-1, s, p) || match(i-1, j, s, p);
        return false;
    }
}