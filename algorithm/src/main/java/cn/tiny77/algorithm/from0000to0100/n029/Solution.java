package cn.tiny77.algorithm.from0000to0100.n029;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().divide(2147483647, 3));
        System.out.println(new Solution().divide(100, 3));
        System.out.println(new Solution().divide(-100, 3));
        System.out.println(new Solution().divide(1, 3));
        System.out.println(new Solution().divide(-2147483648, 2));
    }

    public int divide(int dividend, int divisor) {
        boolean diff = dividend < 0 ^ divisor < 0;
        dividend = dividend < 0 ? dividend : - dividend;
        divisor = divisor < 0 ? divisor : - divisor;
        int result;
        if (divisor == dividend) {
            result = -1;
        } else if (divisor < -1) {
            int old = divisor;
            int pre = divisor;
            while (divisor > dividend && divisor < 0) {
                pre = divisor;
                divisor = divisor << 1;
            }
            if (divisor > 0) {
                divisor = pre;
            }
            result = 0;
            while (true) {
                result = result << 1;
                if (dividend <= divisor) {
                    dividend -= divisor;
                    result -= 1;
                }
                divisor = divisor>> 1;
                if (divisor > old) {
                    break;
                }
            }
        } else {
            result = dividend;
        }
        return diff ? result : (result == -2147483648 ? 2147483647 : -result);
    }

}