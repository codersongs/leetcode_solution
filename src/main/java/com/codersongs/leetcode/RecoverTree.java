package com.codersongs.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wusongsong
 * @date 2019/5/25
 */
public class RecoverTree {
    static TreeNode t1, t2, pre;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);

        root.left = node1;
        node1.right = node2;
        recoverTree(root);

    }


    public static void recoverTree(TreeNode root) {
        inorder(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    public static void inorder(TreeNode root){
        if (root == null) return ;
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }

}
