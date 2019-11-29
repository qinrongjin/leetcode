package cn.tiny77.algorithm.from0000to0100.n039;

import java.util.*;

class Solution {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int candidate : candidates) {
            int newTarget = target - candidate;
            if (newTarget > 0) {
                List<List<Integer>> newResult = combinationSum(candidates, newTarget);
                for (List<Integer> list : newResult) {
                    if (candidate >= list.get(list.size() - 1)) {
                        list.add(candidate);
                        result.add(list);
                    }
                }
            }
            if (newTarget == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(candidate);
                result.add(list);
            }
        }
        return result;
    }

}