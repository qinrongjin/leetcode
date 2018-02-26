package cn.tiny77.algorithm;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class A12 {

    public static void main(String[] arg){
        System.out.println(new A12().longestCommonPrefix(new String[]{
                "ccc","ccc"
        }));

    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        int i = 0;
        for (; i < strs[0].length() ; i++){
            boolean flag = true;
            for(int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                System.out.println("找到位置" + i);
                break;
            }
        }
        return strs[0].substring(0, i);
    }

}
