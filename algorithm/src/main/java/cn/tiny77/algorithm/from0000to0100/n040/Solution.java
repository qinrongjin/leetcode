package cn.tiny77.algorithm.from0000to0100.n040;

import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = combinationSum2(candidates, candidates.length, target);
        Set<String> set = new HashSet<>();
        Iterator<List<Integer>> iterator = lists.iterator();
        while (iterator.hasNext()) {
            List<Integer> next = iterator.next();
            String str = next.toString();
            if (set.contains(str)) {
                iterator.remove();
            } else {
                set.add(str);
            }
        }
        return lists;
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int end, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (end > 0) {
            int candidate = candidates[end - 1];
            int newTarget = target - candidate;
            int next = end - 1;
            if (newTarget > 0) {
                List<List<Integer>> lists = combinationSum2(candidates, next, newTarget);
                for (List<Integer> list : lists) {
                    if (candidate >= list.get(list.size() - 1)) {
                        list.add(candidate);
                        result.add(list);
                    }
                }
            }
            if (newTarget == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(target);
                result.add(list);
            }
            List<List<Integer>> lists = combinationSum2(candidates, next, target);
            for (List<Integer> list : lists) {
                result.add(list);
            }
        }
        return result;
    }
}