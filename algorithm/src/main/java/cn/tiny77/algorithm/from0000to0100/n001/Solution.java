package cn.tiny77.algorithm.from0000to0100.n001;

import java.util.HashMap;

class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i ++) {
                map.put(target - nums[i], i);
            }
            System.out.println(map);
            for (int i = 0; i < nums.length; i ++) {
                Integer j = map.get(nums[i]);
                System.out.println(j);
                if (j != null && i != j) {
                    return new int[] {i, j};
                }
            }
            throw new RuntimeException();
        }
    }