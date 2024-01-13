package com.lhq.subject2.easy.Q7_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/1/12 17:00
 *
 * 合作圈
 * 在一个公司里有 N 名员工。这其中有些人有合作关系，有些则没有。他们的合作关系具有传递性。如果已知 A 和 B 有过合作，B 和 C 也有过合作，那么我们可以认为 A 和 C 也有间接的合作关系。所谓的合作圈，就是所有间接或直接合作过的员工集合。
 *
 * 输入格式:
 * 给定一个 N * N 的矩阵 M（程序实际接收的输入是字符串，参见下面的输入样例），表示公司中员工之间的合作关系。如果 M[i][j] = 1，表示已知第 i 个和第 j 个员工有过间接或直接的合作，否则为没有合作过。
 *
 * 输出格式:
 * 你需要输出所有员工中的已知的合作圈总数。
 *
 * 备注：
 * N 在[1,200]的范围内
 *
 * 对于所有员工，有M[i][i] = 1
 *
 * 如果有M[i][j] = 1，则有M[j][i] = 1
 *
 * 输入样例:
 * 在这里给出一组输入。例如：
 *
 * 1 1 0|1 1 0|0 0 1
 * 在代码中进行处理，使其变成二维数组 [[1,1,0], [1,1,0], [0,0,1]]
 *
 * 输出样例:
 * 根据上面的输入样例，已知员工0和员工1合作过，他们在一个合作圈。 第2个员工自己在一个合作圈。 最后返回2。
 *
 * 2
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] split = s.split("\\|");
        int n = split.length;
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] itemList = split[i].split(" ");
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.valueOf(itemList[j]);
            }
        }
        Main main = new Main();
        System.out.println(main.findCircleNum(array));
    }
    public int findCircleNum(int[][] isConnected) {
        UnionFind unionFind = new UnionFind();
        for (int i = 0; i < isConnected.length; i++) {
            unionFind.add(i);
            //只需要解析对角线的一半就好, 同时初始化时
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1){
                    unionFind.merge(i,j);
                }
            }
        }
        return unionFind.getNumOfSets();
    }

    //并查集
    class UnionFind{
        //定义一个数据结构，每个节点记录他的父节点
        private Map<Integer,Integer> father;
        // 连通域数量
        int numOfSets;

        public UnionFind() {
            father = new HashMap<Integer,Integer>();
            numOfSets = 0;
        }

        //把新节点接入并查集，由于是新的,父节点为null，但是在查询祖先节点是，祖先节点是自己，所以是独立的
        public void add(int x) {
            if (!father.containsKey(x)) {
                father.put(x, null);
                numOfSets++;
            }
        }
        //合并两个节点
        public void merge(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            // 判断是否为同一个祖先，若不是同一个祖先,则要将他们祖先合并,从而使得x与y连通
            if (rootX != rootY){
                father.put(rootX,rootY);
                numOfSets--;
            }
        }
        //判断两个节点是否联通
        public boolean isConnected(int x, int y){
            return find(x) == find(y);
        }
        //查找祖先节点
        public int find(int x){
            //路径压缩，减少树的高度

            //先找到x的祖先节点
            int root = x;
            while(father.get(root) != null){
                //如果x有父节点，向上移动
                root = father.get(root);
            }

            //向上遍历的过程中，不直接挂在root下的全都挂在root下
            while(x != root){
                //记录当前x的父节点
                int original_father = father.get(x);
                //x挂在root下
                father.put(x,root);
                //x上移
                x = original_father;
            }

            return root;
        }

        public  int getNumOfSets(){
            return numOfSets;
        }
    }



}
