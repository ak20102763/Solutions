class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> m = new HashMap<Integer, String>();
		String rom = "";

		m.put(1, "I");
		m.put(4, "IV");
		m.put(5, "V");
		m.put(9, "IX");
		m.put(10, "X");
		m.put(40, "XL");
		m.put(50, "L");
		m.put(90, "XC");
		m.put(100, "C");
		m.put(400, "CD");
		m.put(500, "D");
		m.put(900, "CM");
		m.put(1000, "M");

		int tempNum = num;
		int t = 1;
		while (tempNum / 10 != 0) {
			tempNum /= 10;
			t *= 10;
		}

		if (t * 1 <= num && (4 * t - 1) >= num) {
			rom = m.get(1 * t).repeat(num / (1 * t)).concat(intToRoman(num % (1 * t)));
		} else if (4 * t <= num && 5 * t - 1 >= num) {
			rom = m.get(4 * t).repeat(num / (4 * t)).concat(intToRoman(num % (4 * t)));
		} else if (5 * t <= num && (9 * t - 1) >= num) {
			rom = m.get(t * 5).repeat(num / (5 * t)).concat(intToRoman(num % (5 * t)));
		} else if (9 * t <= num && (10 * t - 1) >= num) {
			rom = m.get(9 * t).repeat(num / (9 * t)).concat(intToRoman(num % (9 * t)));
		}
		return rom;
	}  
}