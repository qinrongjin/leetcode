package cn.tiny77.algorithm;

public class A009 {

	public static void main(String[] args) {

	}

	public boolean isPalindrome(int x) {
		if (x < 0) return false; 
		if (x == reverse(x)) return true;
		else return false;
	}
	
	public int reverse(int x) {
		if(x == Integer.MIN_VALUE) return 0;
		boolean flag = x < 0;
		x = flag ? -x : x;
		int m = (int) Math.pow(10, (int) Math.log10(x));
		long sum = 0;
		long k = 1;
		while(m > 0) {
			sum += x/m * k;
			if(sum > Integer.MAX_VALUE) {
				return 0;
			}
			x %= m;
			m /= 10;
			k *= 10;
		}
		return (int) (flag ? -sum : sum);
	}

}
