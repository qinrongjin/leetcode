package cn.tiny77.algorithm.from0000to0100.n012;

class Solution {
        public String intToRoman(int num) {
            int[] nums = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
            String[] syboms = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
            StringBuilder result = new StringBuilder();
            while (num > 0) {
                int k = 0;
                while (k + 1 < nums.length && nums[k + 1] <= num) {
                    k ++;
                }
                result.append(syboms[k]);
                num -= nums[k];
            }
            return result.toString();
        }
    }