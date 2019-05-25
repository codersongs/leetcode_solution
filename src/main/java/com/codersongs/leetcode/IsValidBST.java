package com.codersongs.leetcode;

/**
 * @author wusongsong
 * @date 2019/5/25
 */
public class IsValidBST {
    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        if (!isValidBST1(root)){
            return false;
        }
        TreeNode current = root.left;
        while (current != null && current.right != null){
            current = current.right;
        }
        if (current != null && current.val >= root.val){
            return false;
        }
        current = root.right;
        while (current != null && current.left != null){
            current = current.left;
        }
        if (current != null && current.val <= root.val){
            return false;
        }
        return true;
    }

    public static boolean isValidBST1(TreeNode root) {
        if (root == null){
            return true;
        }
        if ((root.left != null && root.left.val >= root.val) || (root.right != null && root.right.val <= root.val)){
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
