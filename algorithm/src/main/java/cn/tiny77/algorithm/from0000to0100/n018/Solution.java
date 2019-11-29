package cn.tiny77.algorithm.from0000to0100.n018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 3; ) {
                for (int j = i + 1; j < nums.length - 2; ) {
                    int l = j + 1;
                    int m = nums.length - 1;
                    while (l < m) {
                        int temp = nums[i] + nums[j] + nums[l] + nums[m];
                        if (temp == target) {
                            result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[m]));
                            int pre = nums[l];
                            while (pre == nums[l] && l < m) {
                                l ++;
                            }
                            pre = nums[m];
                            while (pre == nums[m] && l < m) {
                                m --;
                            }
                        }
                        else if (temp > target) {
                            int pre = nums[m];
                            while (pre == nums[m] && l < m) {
                                m --;
                            }
                        }
                        else if (temp < target) {
                            int pre = nums[l];
                            while (pre == nums[l] && l < m) {
                                l ++;
                            }
                        }
                    }
                    int pre = nums[j];
                    while (j < nums.length - 2 && pre == nums[j]) {
                        j ++;
                    }
                }
                int pre = nums[i];
                while (i < nums.length - 3 && pre == nums[i]) {
                    i ++;
                }
            }
            return result;
        }
    }