//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3483 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0){
            return result;
        }
        generate(n,n,"",result);
        return result;

    }
    public void generate(int left, int right, String cur, List<String> result){
        if(left == 0 && right == 0){
            result.add(cur);
        }
        if(left > right){
            //左括号剩余的多说明错了
            return;
        }
        if(left > 0){
            generate(left -1 , right, cur + "(", result);
        }
        if(right > 0){
            generate(left , right - 1, cur + ")", result);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
