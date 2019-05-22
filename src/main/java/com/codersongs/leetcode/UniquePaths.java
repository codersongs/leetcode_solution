package com.codersongs.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(2,2));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0){
            return 0;
        }
        if (m == 1 || n == 1){
            return 1;
        }

        int[][] memory = new int[m+1][n+1];
        memory[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1){
                    memory[i][j] = 1;
                }else {
                    memory[i][j] = memory[i-1][j] + memory[i][j-1];
                }

            }
        }
        return memory[m][n];
    }

    /**
     * 题目可以转换为排列组合问题，解是C(min(m,n), m+n)，从m+n个中选出m个下移或n个右移。
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        long res = 0;
        int threshold = m>n?n-1:m-1;
        long denominator = 1;
        long val = 1;
        for(int i=2; i<=threshold; i++){
            denominator = denominator*i;
        }
        for(int i=0; i<threshold; i++){
            val = val*(m+n-2-i);
        }
        res = val/denominator;
        return res==0?1:(int)res;
    }

}
