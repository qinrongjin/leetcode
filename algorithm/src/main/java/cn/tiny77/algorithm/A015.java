package cn.tiny77.algorithm;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

public class A015 {

    public static void main(String[] arg){
        new A015().threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i ++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j1 = i + 1,j2 = nums.length - 1;
            while (j1 < j2){
                if(j1 == i) {
                    j1++;
                }else if(j2 == i){
                    j2--;
                }else{
                    int num = nums[j1] + nums[j2];
                    if(num == -nums[i]){
                        List<Integer> l = Arrays.asList(nums[i],nums[j1],nums[j2]);
                        list.add(l);
                        while(j1 < j2&&nums[j1]==nums[j1+1]) j1 ++;
                        while(j1 < j2&&nums[j2]==nums[j2-1]) j2 --;
                        j1 ++;
                        j2 --;
                        System.out.println(i + "," + j1 + "," + j2);
                    }else if(num < -nums[i]){
                        j1++;
                    }else{
                        j2--;
                    }
                }
            }
        }
        return list;
    }


}
