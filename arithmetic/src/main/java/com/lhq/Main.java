package com.lhq;

import java.util.Arrays;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/1/3 22:37
 */
public class Main {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,4},{0,2},{3,5}};
        merge(a);
    }

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] merge = new int[n][2];

        //左端点排序
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        //左端点初始化
        merge[0] = intervals[0];
        //记录数组的最后一个元素下标的位置
        int index = 0;
        //左端点已经按照从大到小的顺序排列
        //新数组的右端点如果小于循环中的这个数组的左端点，没有重合，添加进去
        //否则需要合并
        for(int i = 1; i < n; i++){
            if(intervals[i][0] > merge[index][1]){
                index += 1;
                merge[index] = intervals[i];
            }else{
                //由于只排序了左端点不知道右端点谁更长，取大值
                merge[index][i] = Math.max(intervals[i][1], merge[index][1]);
            }
        }
        //如果有合并的话，需要重新生成数组，去掉对于的[0,0] index = length -1
        return Arrays.copyOf(merge, index + 1);
    }
}