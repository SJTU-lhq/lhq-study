package lhq.lhqstudy.arithmetic.ex1110;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/8/18 21:18
 */
public class Solution {
    Set<Integer> set = new HashSet<>();
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        for (int x : toDelete) set.add(x);
        if (dfs(root) != null) ans.add(root);
        return ans;
    }

    private TreeNode dfs( TreeNode node) {
        if (node == null) return null;
        node.left = dfs(node.left);
        node.right = dfs(node.right);
        if (! set.contains(node.val)) return node;
        if (node.left != null) ans.add(node.left);
        if (node.right != null) ans.add(node.right);
        return null;
    }

/*    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i = 0; i < to_delete.length; i++) {
            set.add(to_delete[i]);
        }
        checkRoot(root);
        return ans;
    }

    public void checkRoot(TreeNode root){
        if(root == null){
            return;
        }
        ans.add(root);
        check(null, root, 0);
    }

    public void check(TreeNode parentNode, TreeNode node, Integer flag){
        if(node == null){
            return;
        }
        if(set.contains(node.val)){
            if(parentNode == null){
                ans.remove(node);
            }else {
                if(flag == 0){
                    parentNode.left = null;
                }else {
                    parentNode.right = null;
                }
            }
            checkRoot(node.left);
            checkRoot(node.right);
        }else {
            check(node, node.left, 0);
            check(node, node.right, 1);
        }
    }*/

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
