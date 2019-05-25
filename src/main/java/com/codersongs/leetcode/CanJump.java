package com.codersongs.leetcode;

/**
 * @author wusongsong
 * @date 2019/5/22
 */
public class CanJump {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1){
            return true;
        }
        if (nums[0] == 0){
            return false;
        }
        int index = 0;
        while (index < nums.length){
            int count = nums[index];
            if (count == 0){
                return false;
            }
            if (index + count >= nums.length -1){
                return true;
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
                return false;
            }
            index += nextStep;
        }
        return true;
    }
}
