package cn.tiny77.algorithm.h01.t20.n014;

class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }
            char[] sub = strs[0].toCharArray();
            int length = sub.length;
            for (int i = 1; i < strs.length; i ++) {
                length = compare(strs[i], sub, length);
                if (length == 0) {
                    break;
                }
            }
            return new String(sub, 0, length);
        }

        private int compare(String str, char[] sub, int length) {
            int i = 0;
            while (i < str.length() && i < length) {
                if (sub[i] != str.charAt(i)) {
                    break;
                }
                i ++;
            }
            return i;
        }

    }