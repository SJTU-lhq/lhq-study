package com.lhq.ex543;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/8/18 10:24
 */
public class Solution {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        length(root);
        return max;
    }
    public int length(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = length(root.left);
        int right = length(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    public static class TreeNode {
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
