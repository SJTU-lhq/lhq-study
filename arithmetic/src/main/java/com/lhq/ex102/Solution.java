package com.lhq.ex102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/8/18 13:10
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        List<TreeNode> tmp =  new LinkedList<>();
        tmp.add(root);
        while (! tmp.isEmpty()){
            List<Integer> res = new ArrayList<Integer>();
            for (int i = 0; i < tmp.size(); i++) {
                TreeNode node = tmp.remove(0);
                res.add(node.val);
                if(node.left != null){
                    tmp.add(node.left);
                }
                if(node.right != null){
                    tmp.add(node.right);
                }
            }
            ans.add(res);
        }
        return ans;
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
