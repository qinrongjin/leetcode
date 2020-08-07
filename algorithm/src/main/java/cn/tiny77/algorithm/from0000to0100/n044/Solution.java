package cn.tiny77.algorithm.from0000to0100.n044;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("adceb", "*a*b"));
    }

    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        boolean flag = true;
        for (int j = 1; j <= p.length(); j++) {
            char pc = p.charAt(j - 1);
            if (pc != '*') {
                flag = false;
            }
            for(int i = 1; i <= s.length() ; i ++) {
                char sc = s.charAt(i - 1);
                if (flag) {
                    match[i][j] = true;
                } else {
                    if (pc == '*') {
                        match[i][j] = match[i - 1][j] || match[i][j - 1];
                    } else {
                        if (pc == '?' || pc == sc) {
                            match[i][j] = match[i - 1][j - 1];
                        }
                    }
                }
            }
        }
        displayMatch(match);
        return match[s.length()][p.length()];
    }

    private void displayMatch(boolean[][] match) {
        for (int i = -1; i < match.length; i ++) {
            for (int j = -1; j < match[0].length; j ++) {
                if (i == -1) {
                    if (j == -1) {
                        System.out.print(" \t");
                    } else {
                        System.out.print(" " + j + "\t");
                    }
                } else {
                    if (j == -1) {
                        System.out.print(" " + i + "\t");
                    } else {
                        System.out.print("[" + (match[i][j] ? 1 : 0) + "]\t");
                    }
                }
            }
            System.out.println();
        }
    }


}