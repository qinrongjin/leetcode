package cn.tiny77.algorithm.h01.t40.n022;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        int l = 0;
        int r = 0;
        List<String> result = new ArrayList<>();
        setNext(result, "", n * 2, l , r);
        return result;
    }

    private void setNext(List<String> result, String oriStr, int n, int l, int r) {
        if (n == oriStr.length()) {
            if (l == r) {
                result.add(oriStr);
            }
        } else {
            if (l > r) {
                setNext(result, oriStr + ")", n, l, r + 1);
            }
            setNext(result, oriStr + "(", n, l + 1, r);
        }
    }
}