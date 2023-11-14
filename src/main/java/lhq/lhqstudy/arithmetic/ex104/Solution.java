package lhq.lhqstudy.arithmetic.ex104;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/8/18 00:22
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left > right){
            return left + 1;
        }else {
            return right + 1;
        }
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
