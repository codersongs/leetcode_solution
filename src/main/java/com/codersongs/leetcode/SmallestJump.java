package com.codersongs.leetcode;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

 示例:

 输入: [2,3,1,1,4]
 输出: 2
 解释: 跳到最后一个位置的最小跳跃数是 2。
 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

 说明:

 假设你总是可以到达数组的最后一个位置。

 * @author wusongsong
 * @date 2019/5/22
 */
public class SmallestJump {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        if (nums == null || nums.length <= 1){
            return 0;
        }
        if (nums[0] == 0){
            return 0;
        }
        int index = 0;
        int sum = 0;
        while (index < nums.length){
            int count = nums[index];
            if (count == 0){
                return 0;
            }
            sum++;
            if (index + count >= nums.length -1){
                return sum;
            }
            int max = count - 1;
            int nextStep = 0;
            for (int i = 1; i <= count; i++) {
                if (nums[index + i] > max){
                    max = nums[index+i];
                    nextStep = i;
                }
                max--;
            }
            if (nextStep == 0){
                return 0;
            }
            index += nextStep;
        }
        return sum;
    }
}
