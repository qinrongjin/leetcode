package cn.tiny77.algorithm;

/**
 * Reverse Integer
 * @author mrqin
 *
 */
public class A007 {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(- Integer.MIN_VALUE);
	}

	class Solution {
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
}
