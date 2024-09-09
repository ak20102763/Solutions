class Solution {
    public String countAndSay(int n) {
        StringBuffer res = new StringBuffer();
        if(n==1){
            return "1";
        }
        else{
            String s = countAndSay(n-1);
            StringBuffer sb = new StringBuffer(s);
            int i = 0, c = 0;
            while (i<sb.length()) {
            	c = 1;
            	while(i+c<sb.length() && sb.charAt(i+c-1)==sb.charAt(i+c)) c++;
            	res.append(c).append(sb.charAt(i));
            	i += c;
            }
            return res.toString();
        }
    }
}