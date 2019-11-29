package cn.tiny77.algorithm.from0000to0100.n032;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("(())(()"));
        System.out.println(new Solution().longestValidParentheses("(()()()()())))"));
        System.out.println(new Solution().longestValidParentheses("(()()(()))"));
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        int[] l = new int[s.length()];
        for (int i = 0; i < s.length(); i ++) {
            if (i > 0) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        l[i] = (i >= 2 ? l[i - 2] : 0) + 2;
                        if (l[i] > max) {
                            max = l[i];
                        }
                    } else {
                        if (i > l[i - 1] && s.charAt(i - l[i - 1] - 1) == '(') {
                            l[i] = (i - l[i - 1] >= 2 ? l[i - l[i - 1] - 2] : 0 ) + l[i - 1] + 2;
                            if (l[i] > max) {
                                max = l[i];
                            }
                        }
                    }
                }
            }
        }
        return max;
    }

}