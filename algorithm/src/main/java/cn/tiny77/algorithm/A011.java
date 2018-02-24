package cn.tiny77.algorithm;

public class A011 {

    public static void main(String[] args) {
        System.out.println(new A011().maxArea(new int[]{0,2}));
    }

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
