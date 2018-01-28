package cn.tiny77.algorithm;

public class A008 {

	public static void main(String[] args) {   
		System.out.println(new A008().myAtoi("-234"));
		System.out.println(new A008().myAtoi("+1"));
		System.out.println(new A008().myAtoi("-+1"));
		System.out.println(new A008().myAtoi("010"));
		System.out.println(new A008().myAtoi(""));
		System.out.println(new A008().myAtoi(" 222"));
		System.out.println(new A008().myAtoi("  -0012a42"));
		System.out.println(new A008().myAtoi("   +0 123"));
		System.out.println(new A008().myAtoi("-2147483648"));
		System.out.println(new A008().myAtoi("-2147483649"));
	}

	public int myAtoi(String str) {
		if(!str.matches("^\\s*([-\\+]?\\d\\d*|0).*")) return 0;
		str = str.trim();
		int i = 0;
		for (i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9' || str.charAt(i) == '-' || str.charAt(i) == '+'))
				break;
		}
		str = str.substring(0, i);
		if(str.length() == 1) return (int)(str.charAt(0) - '0');
		if(str.length() == 2 && str.charAt(0) == '-') return -(int)(str.charAt(1) - '0');
		if(str.charAt(0) == '+') str = str.substring(1);
		if(str.charAt(0)=='-') {
			int num = -(str.charAt(1) - '0') * (int)Math.pow(10, str.length() - 2)
					+ myAtoi("-" + str.substring(2));
			if(num > 0) num = Integer.MIN_VALUE;
			return num;
		}else {
			int num = (str.charAt(0) - '0') * (int)Math.pow(10, str.length() - 1)
					+ myAtoi(str.substring(1));
			if(num < 0) num = Integer.MAX_VALUE;
			return num;
		}
	}

}
