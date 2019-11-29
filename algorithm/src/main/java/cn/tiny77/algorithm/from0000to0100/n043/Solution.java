package cn.tiny77.algorithm.from0000to0100.n043;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("123", "456"));
        // System.out.println(new Solution().add("55350", "738"));
    }

    public String multiply(String num1, String num2) {
        return multiply(num1, num2, 0, num2.length());
    }

    private String multiply(String num1, String num2,int num2Start, int num2End) {
        if (num2End - num2Start > 1) {
            String preResult = multiply(num1, num2, 0, num2End - 1);
            if (!"0".equals(preResult)) {
                preResult += "0";
            }
            String result = multiply(num1, num2, num2End - 1, num2End);
            String addResult = add(preResult, result);
            return addResult;
        } else {
            int c2 = num2.charAt(num2Start) - '0';
            if (c2 == 0) {
                return "0";
            }
            if (c2 == 1) {
                return num1;
            }
            String result = "";
            int pro = 0;
            for (int i = 1; i <= num1.length(); i++) {
                int c1 = num1.charAt(num1.length() - i) - '0';
                int re = c1 * c2 + pro;
                if (re >=  10) {
                    pro = re / 10;
                } else {
                    pro = 0;
                }
                re %= 10;
                result = re + result;
            }
            if (pro > 0) {
                result = pro + result;
            }
            return result;
        }
    }

    private String add(String max, String min) {
        String result = "";
        int pro = 0;
        for (int i = 1; i <= max.length(); i++ ){
            int c1 = max.charAt(max.length() - i) - '0';
            int re;
            if (i <= min.length()) {
                int c2 = min.charAt(min.length() - i) - '0';
                re = c1 + c2 + pro;
            } else {
                re = c1 + pro;
            }
            if (re >= 10) {
                pro = 1;
                re -= 10;
            } else {
                pro = 0;
            }
            result = re + result;
        }
        if (pro == 1) {
            result = "1" + result;
        }
        return "".equals(result) ? "0" : result;
    }
}