package lhq.lhqstudy.arithmetic.ex111;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/12/13 21:14
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left!=null&&root.right!=null){
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        return root.left==null ? minDepth(root.right)+1 : minDepth(root.left)+1;

    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
