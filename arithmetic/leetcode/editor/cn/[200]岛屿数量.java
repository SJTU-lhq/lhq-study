//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2401 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    handle(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
     public void handle(char[][] grid, int i, int j){
        if(! inArea(grid, i, j)){
            return;
        }
        if(grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        handle(grid, i-1, j);
        handle(grid, i+1, j);
        handle(grid, i, j-1);
        handle(grid, i, j+1);
     }
     public boolean inArea(char[][] grid, int i, int j){
        return i>=0&& i<grid.length && j >= 0 && j<grid[0].length;
     }
}
//leetcode submit region end(Prohibit modification and deletion)
