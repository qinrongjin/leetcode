package cn.tiny77.algorithm.h01.t40.n033;

import cn.tiny77.algorithm.DataUtils;

class Solution {

    public int search(int[] nums, int target) {
        int result = search(nums, target, 0, nums.length);
        return result;
    }

    private int search(int[] nums, int target, int start, int end) {
        if (nums.length == 0) {
            return -1;
        }
        if (start >= end - 1) {
            if (nums[start] == target) {
                return start;
            }
            return -1;
        }
        int mid = (start + end) / 2;
        int result;
        if (nums[start] > nums[end - 1]) {
            result = search(nums, target, start, mid);
            if (result != -1) {
                return result;
            }
            result = search(nums, target, mid, end);
            if (result != -1) {
                return result;
            }
        } else {
            if (target >= nums[mid]) {
                result = search(nums, target, mid, end);
            } else {
                result = search(nums, target, start, mid);
            }
        }
        return result;
    }
}