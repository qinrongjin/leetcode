package cn.tiny77.algorithm.from0000to0100.n026;

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
             if (nums[i] == nums[j]) {
                 j ++;
             } else {
                 if (i != j) {
                     nums[++i] = nums[j];
                 }
             }
        }
        return i + 1;
    }
}