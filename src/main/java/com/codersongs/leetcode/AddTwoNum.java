package com.codersongs.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class AddTwoNum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,8,5};
        int target = 9;
//        int[] result = twoSum1(nums, target);
        int[] result = twoSum2(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

    /**
     * 方式一：暴力求解，时间复杂度O(n^2)，空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法二：两遍哈希表
     * <p>
     *     利用Hash表查询速度快的优势，降低查询的时间复杂度，时间复杂度O(n)，空间复杂度O(n)
     * </p>
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)){
                return new int[]{i, map.get(num)};
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法三：一遍哈希表
     * <p>
     *  边遍历边放入HashMap中，节省了一次遍历的时间，时间复杂度O(n)，空间复杂度O(n)
     * </p>
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
            
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
