//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1868 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
/*        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while(! nodes.isEmpty()){
            List<Integer> item = new ArrayList<>();
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                item.add(node.val);
                if(node.left != null){
                    nodes.add(node.left);
                }
                if(node.right != null){
                    nodes.add(node.right);
                }
            }
            result.add(item);
        }
        return result;*/

        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        dfs(root, 0 , result);
        return result;
    }
    public void dfs(TreeNode root, Integer level, List<List<Integer>> result){
        //每加一层 level+1 开一个新的list
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if(root.left != null){
            dfs(root.left, level + 1, result);
        }
        if(root.right != null){
            dfs(root.right, level + 1, result);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
