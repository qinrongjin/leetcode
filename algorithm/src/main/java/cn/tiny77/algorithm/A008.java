package cn.tiny77.algorithm;

public class A008 {

	public static void main(String[] args) {
		System.out.println(new A008().new Solution().myAtoi("-6147483648"));
	}

	class Solution {
		public int myAtoi(String str) {
			if (str == null || str.length() == 0) return 0;
			char[] chars = str.toCharArray();
			boolean begin = false;
			int zf = 1;
			int sum = 0;
			for (int i = 0; i < chars.length; i++) {
				char c = chars[i];
				if (c == ' ' || c == '-' || c == '+' || (c >= '0' && c <= '9')) {
					if (begin) {
						if (c >= '0' && c <= '9') {
							int old = sum;
							sum = sum * 10 + (c - '0') * zf;
							if (zf > 0 && sum / 10 != old) {
								return Integer.MAX_VALUE;
							}
							if (zf < 0 && sum / 10 != old) {
								return Integer.MIN_VALUE;
							}
						} else {
							break;
						}
					} else {
						if (c == ' ') {
							continue;
						}
						if (c == '-' || c == '+') {
							begin = true;
							zf = c == '-' ? -1 : 1;
						}
						if (c >= '0' && c <= '9') {
							begin = true;
							sum = (c - '0') * zf;
						}
					}
				} else {
					break;
				}
			}
			return  sum;
		}
	}

}
