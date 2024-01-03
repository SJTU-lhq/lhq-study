package com.lhq.ex283;

/**
 * 星光荡开宇宙，本人闪耀其中
 *
 * @author lhq (sjtu.lhq0215@gmail.com)
 * @description:
 * @data 2023/12/18 21:57
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[j]=nums[i];
                if(i != j){
                    nums[i]=0;
                }
                j++;
            }
        }
    }
}
