package lhq.lhqstudy.arithmetic.tree;


/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/12/13 20:59
 */
public class TreeDemo {
    public static void main(String[] args) {

    }
    void traverse(TreeNode root){
        //前序
        traverse(root.left);
        //中序
        traverse(root.right);
        //后序
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
