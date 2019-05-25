package com.codersongs.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *给定一个二叉树，返回它的中序 遍历。

 示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,3,2]

 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 * @author wusongsong
 * @date 2019/5/25
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.right = node1;
        node1.left = node2;

        System.out.println(inorderTraversal2(root));
    }

    /**
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    /**
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while( current != null||!stack.isEmpty() ){
            while( current != null ){
                stack.push(current);
                current = current.left;
            }
            if( !stack.isEmpty() ){
                current = stack.pop();
                list.add(current.val);
                current = current.right;
            }
        }
        return list;
    }
}



