package com.codersongs.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

 示例:

 输入: 3
 输出: 5
 解释:
 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3


 * @author wusongsong
 * @date 2019/5/25
 */
public class NumTrees {
    public static void main(String[] args) {
        System.out.println(numTrees1(19));
    }

    /**
     * 借用前友的思想，用G(n)表示n个结点的不同二叉树数量。用f(i)表示结点数为n时，以i为根结点二叉树的数量。
     * 那么G(n)=f(1)+f(2)……+f(n)。 而f(i)=G(i-1)G(n-i)——即以i为根结点的二叉树数量等于其左子树个数乘右子树个数。
     * 那么G(n)=G(1)G(n-1)+G(2)G(n-2)……+G(n-1)G(1) （）
     * （）式即为卡特兰数的表达式，到此请移步卡兰特数介绍。 这里可直接循环求出： F(n)=F(n-1)(4n-2)/(n+1)
     * @param n
     * @return
     */
    public static int numTrees1(int n) {
        if (n == 0){
            return 0;
        }
        int[] memory = new int[n+1];
        memory[1] = 1;
        return numTrees1(memory, n);
    }

    /**
     *
     * @param n
     * @return
     */
    public static int numTrees1(int[] memeory, int n) {
        if (memeory[n] > 0){
            return memeory[n];
        }
        long sum = (long)numTrees(n - 1) * (long)(4 * n - 2) / (n + 1);
        memeory[n] = (int)sum;
        return (int)sum;
    }
    /**
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int[][] memory = new int[n+1][n+1];
        if(n == 0){
            return 0;
        }
        return generateTrees(memory, 1,n);
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    public static int generateTrees(int[][] memory, int start,int end) {
        if(start > end){
            return 1;
        }
        if (memory[start][end] > 0){
            return memory[start][end];
        }
        int sum = 0;
        for(int i = start;i <= end;i++){
            int m = generateTrees(memory, start,i-1);
            int n = generateTrees(memory, i+1,end);
            sum += m * n;
        }
        memory[start][end] = sum;
        return sum;
    }
}
