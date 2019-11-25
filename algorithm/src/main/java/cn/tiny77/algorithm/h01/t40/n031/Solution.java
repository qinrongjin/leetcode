package cn.tiny77.algorithm.h01.t40.n031;

class Solution {


    public void nextPermutation(int[] nums) {
        int pro = nextPermutation(nums, 0);
        if (pro == 1) {
            for (int i = 0; i < nums.length / 2; i ++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;
            }
        }
    }

    private int nextPermutation(int[] nums, int start) {
        if (nums.length - start <= 1) {
            return 1;
        } else {
            int n = nums[start];
            int pro = nextPermutation(nums, start + 1);
            if (pro == 1) {
                if (n >= nums[start + 1]) {
                    return 1;
                } else {
                    for (int i = 1; i <= (nums.length - start) / 2; i ++) {
                        int t = nums[start + i];
                        nums[start + i] = nums[nums.length - i];
                        nums[nums.length - i] = t;
                    }
                    int pos = nums.length - 1;
                    for (int i = 1; i < nums.length - start; i ++) {
                        if (nums[start + i] > n) {
                            pos = start + i;
                            break;
                        }
                    }
                    nums[start] = nums[pos];
                    nums[pos] = n;
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }
}