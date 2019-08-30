package cn.tiny77.algorithm;

public class A004 {

    public static void main(String[] args) {
        double d = new A004().new Solution().findMedianSortedArrays(new int[]{1,2,3}, new int[]{2,3,4});
        System.out.println(d);
    }

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int total = nums1.length + nums2.length;
            boolean flag = total % 2 == 1;
            int mid = total / 2;
            int i1 = 0, i2 = 0, pos = 0;
            int num1 = 0, num2 = 0;
            while (pos <= mid) {
                num1 = num2;
                if (i1 < nums1.length && i2 < nums2.length) {
                    if (nums1[i1] > nums2[i2]) {
                        num2 = nums2[i2++];
                    } else {
                        num2 = nums1[i1++];
                    }
                } else if (i1 < nums1.length) {
                    num2 = nums1[i1++];
                } else if (i2 < nums2.length) {
                    num2 = nums2[i2++];
                }
                pos ++;
            }
            return flag ? num2 : (num1 + num2) / 2D;
        }
    }

}
