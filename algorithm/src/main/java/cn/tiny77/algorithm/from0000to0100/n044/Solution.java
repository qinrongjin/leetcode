package cn.tiny77.algorithm.from0000to0100.n044;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab", "b*b*ab**ba*b**b***bba"));
        System.out.println(new Solution().isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
        System.out.println(new Solution().isMatch("a", "a**"));
        System.out.println(new Solution().isMatch("acdcb", "a*c?b"));
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int si, String p, int pi) {
        if (si == s.length() && pi == p.length()) {
            return true;
        }
        if (p.length() > pi) {
            char pc = p.charAt(pi);
            if (pc != '*') {
                if (si < s.length() && (pc == '?' ||  pc == s.charAt(si))) {
                    return isMatch(s, si + 1, p, pi + 1);
                } else {
                    return false;
                }
            } else {
                while (true) {
                    if (pi == p.length() - 1) {
                        return true;
                    }
                    if (p.charAt(pi) != p.charAt(pi + 1)) {
                        break;
                    }
                    pi ++;
                }
                for (; si <= s.length(); si ++) {
                    boolean result = isMatch(s, si, p, pi + 1);
                    if (result) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            if (s.length() > si) {
                return false;
            } else {
                return true;
            }
        }
    }
}