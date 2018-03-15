package cn.tiny77.algorithm;

import java.util.Arrays;

public class A016 {

    public static void main(String[] args) {
        int i = new A016().threeSumClosest(new int[]{0,1,2},3);
        System.out.println(i);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int h = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i ++){
            int j1 = i + 1, j2 = nums.length - 1;
            while (j1 < j2){
                int num = nums[i] + nums[j1] + nums[j2];
                int r = num > target?(num - target):(target - num);
                if(h > r){
                    h = r;
                    res = num;
                    System.out.println("set res = " + res);
                }
                if(num > target){
                    j2 --;
                }else if(num < target){
                    j1 ++;
                }else
                    return res;
            }
        }
        return res;
    }
}
