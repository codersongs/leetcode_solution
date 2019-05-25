package com.codersongs.leetcode;

/**
 * @author wusongsong
 * @date 2019/5/22
 */
public class DisPatchCandy {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,3,2,2,1}));
    }

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0){
            return 0;
        }
        int[] memory = new int[ratings.length];
        memory[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i-1]){
                memory[i] = memory[i-1] + 1;
                continue;
            }
            memory[i] = 1;
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i-1] > ratings[i]){
                memory[i-1] = Math.max(memory[i]+1, memory[i-1]);
            }
        }
        int sum = 0;
        for (int i = 0; i < memory.length; i++) {
            sum += memory[i];
        }
        return sum;
    }
}
