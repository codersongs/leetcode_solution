package com.codersongs.leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class MinPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1,4},{1,5,1,6}, {4,2,1,3}}));
    }

    /**
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memory = new int[m][n];
        memory[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0){
                    continue;
                }
                if (i == 0){
                    System.out.println(i + "," + j);
                    memory[i][j] = memory[i][j-1] + grid[i][j];
                }else if (j == 0){
                    memory[i][j] = memory[i-1][j] + grid[i][j];
                }else {
                    memory[i][j] = Math.min(memory[i-1][j], memory[i][j-1]) + grid[i][j];
                }
            }
        }
        return memory[m-1][n-1];
    }
}
