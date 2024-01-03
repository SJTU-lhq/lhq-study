package com.lhq.ex101;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/8/18 00:46
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return checkChild(root.left, root.right);
    }
    public boolean checkChild(TreeNode left, TreeNode right){
        if(left == null && right ==null){
            return true;
        }
        if((left == null && right != null) || (left!=null && right == null) || left.val != right.val){
            return false;
        }
        return checkChild(left.left, right.right) && checkChild(right.left, left.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
