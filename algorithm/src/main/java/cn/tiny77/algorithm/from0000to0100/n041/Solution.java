package cn.tiny77.algorithm.from0000to0100.n041;


import static cn.tiny77.algorithm.DataUtils.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(toIntArray("[3,4,-1,1]")));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i ++) {
            int tempI = i;
            int n = nums[tempI];
            while (true) {
                if (n != tempI + 1 && n > 0 && n <= nums.length) {
                    int temp = nums[n - 1];
                    nums[n - 1] = n;
                    tempI = n - 1;
                    n = temp;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }


}
