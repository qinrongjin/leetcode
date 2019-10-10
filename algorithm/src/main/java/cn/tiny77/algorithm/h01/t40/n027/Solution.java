package cn.tiny77.algorithm.h01.t40.n027;

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == val) {
                j ++;
            } else {
                if (i != j) {
                    nums[i] = nums[j];
                }
                j ++;
                i ++;
            }
        }
        return i;
    }
}