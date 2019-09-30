package cn.tiny77.algorithm.n001m20.n016;

import java.util.Arrays;

class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int res = 0;
            Integer h = Integer.MAX_VALUE;
                for (int i = 0; i < nums.length; i ++){
                int j1 = i + 1, j2 = nums.length - 1;
                while (j1 < j2){
                    int num = nums[i] + nums[j1] + nums[j2];
                    int r = 0;
                    if(num > target){
                        j2 --;
                        r = num - target;
                    }else if(num < target){
                        j1 ++;
                        r = target - num;
                    }else {
                        return num;
                    }
                    if(h > r){
                        h = r;
                        res = num;
                    }
                }
            }
            return res;
        }
    }