package cn.tiny77.algorithm.h01.t20.n015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> list = new ArrayList<>();
            Integer pre = null;
            for (int i = 0; i < nums.length - 2; i ++) {
                if (pre != null && pre.equals(nums[i])) {
                    continue;
                } else {
                    pre = nums[i];
                }
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[i] + nums[l] + nums[r] == 0) {
                        List<Integer> li = new ArrayList<>();
                        li.add(nums[i]);
                        li.add(nums[l]);
                        li.add(nums[r]);
                        list.add(li);
                        int preL = nums[l];
                        while (l < r && preL == nums[l]) {
                            l ++;
                        }
                        int preR = nums[r];
                        while (l < r && preR == nums[r]) {
                            r --;
                        }
                    } else {
                        if (nums[i] + nums[l] + nums[r] > 0) {
                            r--;
                        }
                        if (nums[i] + nums[l] + nums[r] < 0) {
                            l++;
                        }
                    }
                }
            }
            return list;
        }

    }