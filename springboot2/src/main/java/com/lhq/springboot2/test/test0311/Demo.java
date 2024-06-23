package com.lhq.springboot2.test.test0311;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/3/11 20:14
 */
public class Demo {
    public List<List<Integer>> handle(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while(! nodes.isEmpty()){
            List<Integer> item = new ArrayList<>();
            int size = nodes.size();
            for(int i = 0; i < size; i++){
                TreeNode node = nodes.poll();
                item.add(node.val);
                if(node.left != null){
                    nodes.offer(node.left);
                }
                if(node.right != null){
                    nodes.offer(node.right);
                }
            }
            result.add(item);
        }
        return result;
    }
        class TreeNode {
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
