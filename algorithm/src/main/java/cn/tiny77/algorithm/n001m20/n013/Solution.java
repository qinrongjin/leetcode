package cn.tiny77.algorithm.n001m20.n013;

class Solution {
        public int romanToInt(String s) {
            int sum = 0;
            for (int i = 0; i < s.length() ; i ++) {
                char c = s.charAt(i);
                if (i == s.length() - 1) {
                    sum += getNum(c);
                } else {
                    if (match(c, s.charAt(i + 1))) {
                        sum += getNum(c + "" + s.charAt(i + 1));
                        i ++;
                    } else {
                        sum += getNum(c);
                    }
                }
            }
            return sum;
        }

        private boolean match(char c1, char c2) {
            return c1 == 'I' && (c2 == 'V' || c2 == 'X')
                    || c1 == 'X' && (c2 == 'L' || c2 == 'C')
                    || c1 == 'C' && (c2 == 'D' || c2 == 'M');
        }

        public int getNum(String c) {
            return getNum(c.charAt(1)) - getNum(c.charAt(0));
        }

        public int getNum(char c) {
            switch (c) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
            }
            return 0;
        }
    }