package com.codersongs.leetcode;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray3(nums));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int[] memeory = new int[nums.length];
        memeory[0] = max;
        for (int i = 1; i < nums.length; i++) {
            if (memeory[i-1] <= 0){
                memeory[i] = nums[i];
            }else {
                memeory[i] = nums[i] + memeory[i-1];
            }
            max = Math.max(max, memeory[i]);
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int last = nums[0];
        int max = last;
        for (int i = 1; i < nums.length; i++) {
            int current = 0;
            if (last <= 0){
                current = nums[i];
            }else {
                current = nums[i] + last;
            }
            max = Math.max(max, current);
            last = current;
        }
        return max;
    }

    public static int maxSubArray3(int[] nums) {
        return maxSubArrayPart(nums,0,nums.length-1);
    }

    private static int maxSubArrayPart(int[] nums,int left,int right){
        if(left==right){
            return nums[left];
        }
        int mid=(left+right)/2;
        return Math.max(
                maxSubArrayPart(nums,left,mid),
                Math.max(
                        maxSubArrayPart(nums,mid+1,right),
                        maxSubArrayAll(nums,left,mid,right)
                )
        );
    }

    //左右两边合起来求解
    private static int maxSubArrayAll(int[] nums,int left,int mid,int right){
        int leftSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=mid;i>=left;i--){
            sum+=nums[i];
            if(sum>leftSum){
                leftSum=sum;
            }
        }
        sum=0;
        int rightSum=Integer.MIN_VALUE;
        for(int i=mid+1;i<=right;i++){
            sum+=nums[i];
            if(sum>rightSum){
                rightSum=sum;
            }
        }
        return leftSum+rightSum;
    }
}
