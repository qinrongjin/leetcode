package cn.tiny77.algorithm;

public class A005 {

    public static void main(String[] args) {
        String res = new A005().new Solution().longestPalindrome("abacab");
        System.out.println(res);
    }

    class Solution {
        public String longestPalindrome(String s) {
            StringBuilder stringBuilder = new StringBuilder("#");
            for (char c :s.toCharArray()){
                stringBuilder.append(c).append("#");
            }
            char[] arr = stringBuilder.toString().toCharArray();
            int[] m = new int[arr.length];
            int max = 0;
            int pos = 0;
            for (int i = 0; i < arr.length; i++) {
                int j = 1;
                int r = pos + max;
                if (i < r) {
                    int le = 2 * pos - i;
                    if (m[le] <= r - i) {
                        j = m[le];
                    } else {
                        j = r - i;
                    }
                }
                while (i - j >= 0 && i + j < arr.length
                        && arr[i - j] == arr[i + j]) {
                    j++;
                }
                m[i] = j;
                if (j > max) {
                    max = j;
                    pos = i;
                }
            }
            return stringBuilder.substring(pos - max + 1, pos + max).replace("#", "");
        }
    }
}
