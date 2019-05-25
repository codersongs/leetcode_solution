package com.codersongs.leetcode;

/**
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。

 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

 说明: 请尽可能地优化你算法的时间和空间复杂度。

 示例 1:

 输入:
 nums1 = [3, 4, 6, 5]
 nums2 = [9, 1, 2, 5, 8, 3]
 k = 5
 输出:
 [9, 8, 6, 5, 3]

 示例 2:

 输入:
 nums1 = [6, 7]
 nums2 = [6, 0, 4]
 k = 5
 输出:
 [6, 7, 6, 0, 4]

 示例 3:

 输入:
 nums1 = [3, 9]
 nums2 = [8, 9]
 k = 3
 输出:
 [9, 8, 9]


 * @author wusongsong
 * @date 2019/5/22
 */
public class MaxNumber {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        int[] ints = maxNumber2(new int[]{8,9,7,3,5,9,1,0,8,5,3,0,9,2,7,4,8,9,8,1,0,2,0,2,7,2,3,5,4,7,4,1,4,0,1,4,2,1,3,1,5,3,9,3,9,0,1,7,0,6,1,8,5,6,6,5,0,4,7,2,9,2,2,7,6,2,9,2,3,5,7,4,7,0,1,8,3,6,6,3,0,8,5,3,0,3,7,3,0,9,8,5,1,9,5,0,7,9,6,8,5,1,9,6,5,8,2,3,7,1,0,1,4,3,4,4,2,4,0,8,4,6,5,5,7,6,9,0,8,4,6,1,6,7,2,0,1,1,8,2,6,4,0,5,5,2,6,1,6,4,7,1,7,2,2,9,8,9,1,0,5,5,9,7,7,8,8,3,3,8,9,3,7,5,3,6,1,0,1,0,9,3,7,8,4,0,3,5,8,1,0,5,7,2,8,4,9,5,6,8,1,1,8,7,3,2,3,4,8,7,9,9,7,8,5,2,2,7,1,9,1,5,5,1,3,5,9,0,5,2,9,4,2,8,7,3,9,4,7,4,8,7,5,0,9,9,7,9,3,8,0,9,5,3,0,0,3,0,4,9,0,9,1,6,0,2,0,5,2,2,6,0,0,9,6,3,4,1,2,0,8,3,6,6,9,0,2,1,6,9,2,4,9,0,8,3,9,0,5,4,5,4,6,1,2,5,2,2,1,7,3,8,1,1,6,8,8,1,8,5,6,1,3,0,1,3,5,6,5,0,6,4,2,8,6,0,3,7,9,5,5,9,8,0,4,8,6,0,8,6,6,1,6,2,7,1,0,2,2,4,0,0,0,4,6,5,5,4,0,1,5,8,3,2,0,9,7,6,2,6,9,9,9,7,1,4,6,2,8,2,5,3,4,5,2,4,4,4,7,2,2,5,3,2,8,2,2,4,9,8,0,9,8,7,6,2,6,7,5,4,7,5,1,0,5,7,8,7,7,8,9,7,0,3,7,7,4,7,2,0,4,1,1,9,1,7,5,0,5,6,6,1,0,6,9,4,2,8,0,5,1,9,8,4,0,3,1,2,4,2,1,8,9,5,9,6,5,3,1,8,9,0,9,8,3,0,9,4,1,1,6,0,5,9,0,8,3,7,8,5}, new int[]{7,8,4,1,9,4,2,6,5,2,1,2,8,9,3,9,9,5,4,4,2,9,2,0,5,9,4,2,1,7,2,5,1,2,0,0,5,3,1,1,7,2,3,3,2,8,2,0,1,4,5,1,0,0,7,7,9,6,3,8,0,1,5,8,3,2,3,6,4,2,6,3,6,7,6,6,9,5,4,3,2,7,6,3,1,8,7,5,7,8,1,6,0,7,3,0,4,4,4,9,6,3,1,0,3,7,3,6,1,0,0,2,5,7,2,9,6,6,2,6,8,1,9,7,8,8,9,5,1,1,4,2,0,1,3,6,7,8,7,0,5,6,0,1,7,9,6,4,8,6,7,0,2,3,2,7,6,0,5,0,9,0,3,3,8,5,0,9,3,8,0,1,3,1,8,1,8,1,1,7,5,7,4,1,0,0,0,8,9,5,7,8,9,2,8,3,0,3,4,9,8,1,7,2,3,8,3,5,3,1,4,7,7,5,4,9,2,6,2,6,4,0,0,2,8,3,3,0,9,1,6,8,3,1,7,0,7,1,5,8,3,2,5,1,1,0,3,1,4,6,3,6,2,8,6,7,2,9,5,9,1,6,0,5,4,8,6,6,9,4,0,5,8,7,0,8,9,7,3,9,0,1,0,6,2,7,3,3,2,3,3,6,3,0,8,0,0,5,2,1,0,7,5,0,3,2,6,0,5,4,9,6,7,1,0,4,0,9,6,8,3,1,2,5,0,1,0,6,8,6,6,8,8,2,4,5,0,0,8,0,5,6,2,2,5,6,3,7,7,8,4,8,4,8,9,1,6,8,9,9,0,4,0,5,5,4,9,6,7,7,9,0,5,0,9,2,5,2,9,8,9,7,6,8,6,9,2,9,1,6,0,2,7,4,4,5,3,4,5,5,5,0,8,1,3,8,3,0,8,5,7,6,8,7,8,9,7,0,8,4,0,7,0,9,5,8,2,0,8,7,0,3,1,8,1,7,1,6,9,7,9,7,2,6,3,0,5,3,6,0,5,9,3,9,1,1,0,0,8,1,4,3,0,4,3,7,7,7,4,6,4,0,0,5,7,3,2,8,5,1,4,5,8,5,6,7,5,7,3,3,9,6,8,1,5,1,1,1,0,3}, 500);
        int[] ints = maxNumber2(new int[]{3,4,6,5}, new int[]{9,1,2,5,8,3}, 5);
        System.out.println("total:" + (System.currentTimeMillis() - start));
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        return maxNumber(nums1, nums2, -1, -1, k);
    }

    /**
     *
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @param m 第一个数组的开始索引
     * @param n 第二个数组的开始索引
     * @param k 生成数字的位数
     * @return
     */
    public static int[] maxNumber(int[] nums1, int[] nums2, int m, int n, int k) {
        int[] result = new int[k];
        int min1 = m, min2 = n;
        for (int i = 1; i <= k; i++) {
            int max1 = -1, maxIndex1 = 0;
            int max2 = -1, maxIndex2 = 0;

            for (int j = min1 + 1; j < nums1.length; j++) {
                //获取数组1和2剩余的元素数，避免剩余元素不够选择的情况
                if ((nums2.length - min2 - 1) + (nums1.length - j - 1) < k -i ){
                    break;
                }
                if (nums1[j] > max1){
                    max1 = nums1[j];
                    maxIndex1 = j;
                    if (max1 == 9){
                        break;
                    }
                }
            }
            for (int j = min2 + 1; j < nums2.length; j++) {
                if ((nums1.length - min1 - 1) + (nums2.length - j - 1) < k -i ){
                    break;
                }
                if (nums2[j] > max2){
                    max2 = nums2[j];
                    maxIndex2 = j;
                    if (max2 == 9){
                        break;
                    }
                }
            }
//            System.out.println("k:" + k);
            if (max2 > max1){
                min2 = maxIndex2;
                result[i-1] = max2;
            }else if (max2 < max1){
                min1 = maxIndex1;
                result[i-1] = max1;
            }else {
                //如果max1 == max 2
                result[i-1] = max1;
                compareAndMerge(maxNumber(nums1, nums2, maxIndex1, min2, k - i), maxNumber(nums1, nums2, min1, maxIndex2, k - i), result, i);
//                System.out.println("return");
                return result;
            }
        }
        return result;
    }

    public static void compareAndMerge(int[] result1, int[] result2, int[] result, int index){
        int[] tmp = null;
        for (int i = 0; i < result1.length; i++) {
            if (result1[i] == result2[i]){
                continue;
            }
            tmp = result1[i] > result2[i] ? result1 : result2;
            break;
        }
        if (tmp == null){
            tmp = result1;
        }
        for (int i = 0; i < tmp.length; i++) {
            result[i+index] = tmp[i];
        }
    }


    /**
     * 假设数组一为[3,4,6,5]、数组二为[9,1,2,5,8,3]、k = 5;
     组合情况有0 + 5、1 + 4、2 + 3、3 + 2、4 + 1五种情况,就是从此五种情况取出组合最大的一种;
     Math.max(0, k - n)表示若数组二的元素个数 >= k,则数组一的元素个数可以从0开始取,否则在数组二的大小基础上补.
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static int[] maxNumber2(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] arr = merge(maxArr(nums1, i), maxArr(nums2, k - i), k);
            if (gt(arr, 0, res, 0)){ res = arr;}
        }
        return res;
    }

    /**
     * 假设选择了2 + 3的情况,分别从两个数组取出相应元素个数的最大组合，对数组一来说就是[6,5],对数组二来说是[9,8,3];
     n - i : 当前数组中,当前下标到结尾还有多少个元素;
     j : 当前数组中i之前有多少个数加入到最大组合中;
     n - i + j > k <=> n - i - 1 + j >= k : 当前下标的元素大于最大组合的末尾元素，就需要弹出,弹出后的元素减少,故j--,
     n - i(数组剩余元素) - 1(去掉最大组合末尾元素) + j(最大组合中剩余元素)时刻保持 >= k;
     if j < k : 先将最大组合填满再进行比较替换操作
     * @param nums
     * @param k
     * @return
     */
    private static int[] maxArr(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (n - i + j > k && j > 0 && nums[i] > res[j-1]){
                j--;
            }
            if (j < k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }

    /**
     * 比较从某一个位置开始两个数组组成的数字大小
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    private static  int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++){
            res[r] = gt(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }

        return res;
    }

    /*
    比较两数组相应位置大小,相等就一直跳过,直到不相等就比较.
     */
    private static boolean gt(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}
