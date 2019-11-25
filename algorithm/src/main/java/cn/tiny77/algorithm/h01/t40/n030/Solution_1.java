package cn.tiny77.algorithm.h01.t40.n030;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        List<Integer> /*re = new Solution().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        System.out.println(re);
        re = new Solution().findSubstring("", new String[]{});
        System.out.println(re);
        re = new Solution().findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"});
        System.out.println(re);
        re = new Solution().findSubstring("aaa", new String[]{"a","b"});
        System.out.println(re);*/
        re = new Solution().findSubstring("ab", new String[]{"a","b"});
        System.out.println(re);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) {
            return result;
        }
        int wl = words[0].length();
        int allWl = words.length * wl;
        for (int i = 0; i < s.length() - allWl + 1; i ++) {
            int[] arr = new int[words.length];
            for (int pos = 0; pos < allWl; pos += wl) {
                boolean flag = false;
                for (int j = 0; j < words.length; j++) {
                    if (arr[j] == 0) {
                        if (eq(s, i + pos, words[j], wl)) {
                            arr[j] = 1;
                            flag = true;
                            break;
                        }
                    }
                }
                if (!flag) {
                    break;
                }
            }
            boolean flag = true;
            for (int a : arr) {
                if (a != 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean eq(String s, int i, String word, int wl) {
        for (int j = 0; j < wl; j ++) {
            if (s.charAt(i + j) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}