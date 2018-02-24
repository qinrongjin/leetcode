package cn.tiny77.algorithm;

public class A011 {

    public static void main(String[] args) {
        System.out.println(new A011().maxArea(new int[]{0,2}));
    }

    public int maxArea(int[] height) {
        int maxArea = -1;
        int maxJ = -1;
        int maxI = -1;
        for(int i = 0; i < height.length; i ++) {
            if(maxI>=0 && height[maxI] >= height[i]){
                System.out.println("历史最大左边界" + height[maxI] + "大于当前边界" + height[i] + "，跳过");
                continue;
            }
            for(int j = maxJ == -1 ? height.length - 1 : maxJ; j > i; j --){
                if(height[j] < height[i]){ // 当低于左边界 一个个比较
                    if(j==maxJ || maxJ == -1 || height[j] > height[maxJ]){
                        int area = (j - i) * height[j];
                        if(area > maxArea) {
                            maxArea = area;
                            maxJ = j;
                            maxI = i;
                        }
                    }
                }else { // 高于等于左边界  不再寻找
                    int area = (j - i) * height[i];
                    if(area > maxArea) {
                        maxArea = area;
                        maxJ = j;
                        maxI = i;
                    }
                    break;
                }
            }
            System.out.println("以" + height[i] + "为左边，查询到最大的体积为" + maxArea + "，右边为" + height[maxJ]);
        }
        return maxArea;
    }

}
