package cn.tiny77.algorithm.n001m20.n011;

class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int max = 0;
            while(l < r){
                int cur = (r - l)*(height[l] > height[r] ? height[r]:height[l]);
                if(cur > max) {
                    max = cur;
                }
                if(height[l] > height[r]){
                    r -= 1;
                }else{
                    l += 1;
                }
            }
            return max;
        }
    }