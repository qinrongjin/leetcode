package cn.tiny77.algorithm.from0000to0100.n010;

class Solution {
        public boolean isMatch(String s, String p) {
            String[] ps = new String[p.length()];
            int size = 0;
            for(char c : p.toCharArray()) {
                if (c != '*') {
                    ps[size++] = String.valueOf(c);
                } else {
                    ps[size - 1] += c;
                }
            }
            boolean match = match(ps, size, 0, s, 0);
            return match;
        }

        private boolean match(String[] ps, int size , int iPs, String s, int iS) {
            if (iPs >= size && iS >= s.length()) {
                return true;
            }
            if (iPs >= size) {
                return false;
            }
            if (iS >= s.length()) {
                // 字符串匹配完了 看正则剩下的是不是不用匹配的
                while (iPs < size) {
                    if (!ps[iPs].contains("*")) {
                        return false;
                    }
                    iPs ++;
                }
                return true;
            }
            String p = ps[iPs];
            if (!p.contains("*")) {
                if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(iS)) {
                    return match(ps, size, iPs + 1, s, iS + 1);
                } else {
                    return false;
                }
            } else {
                char c = p.charAt(0);
                while(true) {
                    boolean flag = match(ps, size, iPs + 1, s, iS);
                    if (flag) {
                        return true;
                    }
                    if (iS >= s.length() || s.charAt(iS) != c && c != '.') {
                        break;
                    }
                    iS ++;
                }
                return false;
            }
        }
    }