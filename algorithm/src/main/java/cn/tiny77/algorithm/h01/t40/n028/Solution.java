package cn.tiny77.algorithm.h01.t40.n028;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("aaaab", "b"));
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        char[] ss = haystack.toCharArray();
        char[] s = needle.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            int j = 0;
            if (ss[i] != s[0]) {
                while (++i < ss.length && ss[i] != needle.charAt(0));
            }
            while(i + j < ss.length && j < s.length && haystack.charAt(i + j) == s[j]) {
                j ++;
            }
            if (j == s.length) {
                return i;
            }
        }
        return -1;
    }
}