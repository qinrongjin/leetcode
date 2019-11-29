package cn.tiny77.algorithm.from0000to0100.n035;

import cn.tiny77.algorithm.DataUtils;

class Solution {

    public static void main(String[] args) {
        int[] arr = DataUtils.toIntArray("1,3,5,7");
        System.out.println(new Solution().searchInsert(arr, 9));
    }

    public int searchInsert(int[] nums, int target) {
        int pos = binSearch(nums, target, 0, nums.length);
        return pos;
    }

    private int binSearch(int[] nums, int target, int start, int end) {
        if (nums.length == 0) {
            return 0;
        }
        if (start == end - 1) {
            return target > nums[start] ? start + 1 : start;
        }
        int mid = (start + end) / 2;
        if (target >= nums[mid]) {
            return binSearch(nums, target, mid, end);
        } else {
            return binSearch(nums, target, start, mid);
        }
    }
}