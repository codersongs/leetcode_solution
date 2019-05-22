package com.codersongs.leetcode;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,7,9};
        int[] nums2 = new int[]{2,4,6,8};

        double medianSortednums1rrays = findMedianSortednums1rrays3(nums1, nums2);
        System.out.println(medianSortednums1rrays);
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortednums1rrays(int[] nums1, int[] nums2) {
        int mid = (int) Math.ceil(((double) nums1.length + (double) nums2.length) / 2);
        int i = 0, j = 0, current = 0;
        int num1 = 0, num2 = 0;
        while(i < nums1.length || j < nums2.length){
            if (i < nums1.length){
                if (j >= nums2.length || nums1[i] <= nums2[j]){
                    current = nums1[i++];
                    if (i + j  == mid){
                        if ((nums1.length + nums2.length) % 2 == 1){
                            return current;
                        }else {
                            num1 = current;
                        }

                    }
                    if (i + j - 1 == mid){
                        num2 = current;
                        break;
                    }
                    continue;
                }

            }

            if (j < nums2.length){
                if (i >= nums1.length || nums1[i] > nums2[j]){
                    current = nums2[j++];
                }
            }
            if (i + j == mid){
                if ((nums1.length + nums2.length) % 2 == 1){
                    return current;
                }else {
                    num1 = current;
                }

            }
            if (i + j - 1== mid){
                num2 = current;
                break;
            }

        }


        return (double) (num1 + num2) / 2;

    }


    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortednums1rrays2(int[] nums1, int[] nums2) {
        int mid = (int) Math.ceil(((double) nums1.length + (double) nums2.length) / 2);
        int i = 0, j = 0, current = 0;
        boolean isFirst = false;
        int num1 = 0, num2 = 0;
        while(i < nums1.length || j < nums2.length){
            if (i < nums1.length){
                if (j >= nums2.length || nums1[i] <= nums2[j]){
                    current = nums1[i];
                    isFirst = true;
                }

            }

            if (j < nums2.length){
                if (i >= nums1.length || nums1[i] > nums2[j]){
                    current = nums2[j];
                    isFirst = false;
                }
            }

            if (i + j + 1 == mid){
                if ((nums1.length + nums2.length) % 2 == 1){
                    return current;
                }else {
                    num1 = current;
                }

            }
            if (i + j == mid){
                num2 = current;
                break;
            }
            if (isFirst){
                i++;
            }else {
                j++;
            }


        }


        return (double) (num1 + num2) / 2;

    }

    public static double findMedianSortednums1rrays3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { // to ensure m<=n
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j-1] > nums1[i]){
                iMin = i + 1; // i is too small
            }else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i - 1; // i is too big
            }else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j-1];
                }else if (j == 0) {
                    maxLeft = nums1[i-1];
                }else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ( (m + n) % 2 == 1 ) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                }else if (j == n) {
                    minRight = nums1[i];
                }else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

}
