package cn.tiny77.algorithm;

public class A006 {

    public static void main(String[] args) {
        String res = new A006().new Solution().convert("0", 1);
        System.out.println(res);
    }

    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            StringBuilder res = new StringBuilder();
            char[] arr = s.toCharArray();
            for (int i = 0; i < numRows ; i ++) {
                int j = i;
                int flag = 1;
                boolean add = true;
                while (j < arr.length) {
                    if (add) {
                        res.append(arr[j]);
                    }
                    // 计算下三角
                    int t;
                    if (flag == 1) {
                        t = numRows - i - 1;
                    } else {
                        t = i;
                    }
                    flag = 1 - flag;
                    if (t != 0) {
                        j = j + getX(t);
                        add = true;
                    } else {
                        add = false;
                    }
                }
            }
            return res.toString();
        }

        private int getX(int t) {
            return t * 2;
        }
    }
}
