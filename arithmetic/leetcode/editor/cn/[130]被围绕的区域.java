//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1073 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int rowNum = 0;
    int colNum = 0;
    int tag = 0;
    public void solve(char[][] board) {
        if(board.length == 0){
            return;
        }
        rowNum = board.length;
        colNum = board[0].length;
        tag = rowNum * colNum;
        //需要将边界的0 指向tag
        UnionFind unionFind = new UnionFind(rowNum * colNum + 1);
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if(board[i][j] == '0'){
                    //边界上合并到tag
                    //非边界尝试合并周围
                    if(i==0 || i==rowNum - 1 || j==0 || j == colNum -1){
                        unionFind.merge(index(i,j), tag);
                    }else {
                        if(i > 0 &&board[i - 1][j] == '0'){
                            unionFind.merge(index(i, j), index(i - 1, j));
                        }
                        if(i < rowNum - 1 && board[i + 1][j] == '0'){
                            unionFind.merge(index(i, j), index(i + 1, j));
                        }
                        if(j > 0 && board[i][j - 1] == '0'){
                            unionFind.merge(index(i, j), index(i, j - 1));
                        }
                        if(j < colNum - 1 && board[i][j + 1] == '0'){
                            unionFind.merge(index(i, j), index(i, j + 1));
                        }
                    }

                }
            }
        }

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if(board[i][j] == 'O' && !unionFind.isConnected(index(i, j), tag)){
                    board[i][j] = 'X';
                }
            }
        }
    }
    //计算当前位置的一维坐标（二维转为一维)
    public int index(int i, int j){
        return i * colNum + j;
    }

    class UnionFind{
        private int[] p;
        public UnionFind(int n){
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }
        public void merge(int x, int y) {
            int rootx = find(x), rooty = find(y);
            if (rootx != rooty) {
                p[rootx] = p[rooty];
            }
        }

        public int find(int i) {
            //查找当前树的根节点
            int root = i;
            while(root != p[root])
                root = p[root];

            //路径压缩
            int next;
            while(i != p[i]){
                next = p[i];
                p[i] = root;
                i = next;
            }
            return root;
        }

        // 判断是否 x, y 是否在一个集合中
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
