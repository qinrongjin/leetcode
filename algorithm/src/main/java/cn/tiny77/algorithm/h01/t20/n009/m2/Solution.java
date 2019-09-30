package cn.tiny77.algorithm.h01.t20.n009.m2;

/**
     * 非字符串方法
     */
    class Solution {
        public boolean isPalindrome(int x) {
            return x >= 0 && x == revertNum(x);
        }

        private int revertNum(int x) {
            int sum = 0;
            while (x > 0) {
                sum = sum * 10 + x % 10;
                x /= 10;
            }
            return sum;
        }
    }