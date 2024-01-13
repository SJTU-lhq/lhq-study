package com.lhq.leet.ex11;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/12/18 15:47
 */
public class Solution {
/*    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                maxArea = Math.max(maxArea, (i - j) * Math.min(height[i], height[j]));
            }
        }
        return maxArea;
    }*/

    public int maxArea(int[] height) {
        int maxArea = 0, i = 0, j = height.length-1;
        while(i<j){
            int minHeight = height[i] < height[j]?height[i++]:height[j--];
            maxArea = Math.max(maxArea, (j-i + 1)*minHeight);
        }
        return maxArea;
    }
}
