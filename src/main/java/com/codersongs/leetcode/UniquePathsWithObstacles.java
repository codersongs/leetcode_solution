package com.codersongs.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] obstaclesGrid = new int[][]{{0,0,0,0},{0,1,0,0}, {0,0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstaclesGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0){
            return 0;
        }
        if (obstacleGrid[0].length == 0){
            return 0;
        }
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int n = obstacleGrid[0].length;
        int m = obstacleGrid.length;
        if (obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        int[][] memory = new int[m][n];
        memory[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0){
                    continue;
                }
                if (i == 0 ) {
                    memory[i][j] = obstacleGrid[i][j] == 1 ? 0 : memory[i][j-1];
                }else if (j == 0){
                    memory[i][j] = obstacleGrid[i][j] == 1 ? 0 : memory[i-1][j];
                }else {
                    int top =  obstacleGrid[i-1][j] == 1 ? 0 : memory[i-1][j];
                    int left = obstacleGrid[i][j-1] == 1 ? 0 : memory[i][j-1];
                    memory[i][j] = top + left;
                }
            }
        }
        return memory[m-1][n-1];
    }
}
