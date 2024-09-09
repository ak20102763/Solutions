class Solution {
    public int longestValidParentheses(String s) {

	        var stack = new Stack<Integer>();
		int max = 0, i = 0;
		stack.push(-1);

		while (i < s.length()) {
			if (s.charAt(i) == '(') stack.push(i);
			else {
			    stack.pop();
			    if (stack.isEmpty()) stack.push(i);
			    else max = Math.max(max, i - stack.peek());
			}
			i++;
		}

		return max;
	}
}