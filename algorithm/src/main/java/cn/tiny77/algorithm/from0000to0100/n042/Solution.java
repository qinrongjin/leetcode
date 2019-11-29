package cn.tiny77.algorithm.from0000to0100.n042;

import static cn.tiny77.algorithm.DataUtils.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().trap(toIntArray("[0,1,0,2,1,0,1,3,2,1,2,1]")));
    }

    public int trap(int[] height) {
        int[] v = new int[height.length];
        int left = 0;
        int right = height.length - 1;
        while (left < right - 1) {
            if (height[left] > height[right]) {
                int r = right - 1;
                while (r > left && height[right] > height[r]) {
                    v[r] = height[right] - height[r];
                    r --;
                }
                right = r;
            } else {
                int l = left + 1;
                while (l < right && height[l] < height[left]) {
                    v[l] = height[left] - height[l];
                    l ++;
                }
                left = l;
            }
        }
        int re = 0;
        for (int i : v) {
            re += i;
        }
        return re;
    }


}