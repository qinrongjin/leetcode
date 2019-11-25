package cn.tiny77.algorithm.h01.t40.n034;

class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        searchRange(nums, target, 0, nums.length, result);
        return result;
    }

    private void searchRange(int[] nums, int target, int start, int end, int[] result) {
        if (nums.length == 0) {
            return;
        }
        if (start >= end - 1) {
            if (nums[start] == target) {
                saveToResult(result, start);
            }
            return;
        }
        int mid = (start + end) / 2;
        if (nums[mid] >= target) {
            searchRange(nums, target, start, mid, result);
        }
        if (nums[mid] <= target) {
            searchRange(nums, target, mid, end, result);
        }
    }

    private void saveToResult(int[] result, int pos) {
        if (result[0] == -1 || result[0] > pos) {
            result[0] = pos;
        }
        if (result[1] < pos) {
            result[1] = pos;
        }
    }

}