package com.lhq.ex560;

/**
 * 星光荡开宇宙，本人闪耀其中
 *
 * @author LHQ
 * @data 2023/8/14 22:17
 */
public class Solution {
    public static void main(String[] args) {
        int[] sums = new int[]{1,1,1};
        System.out.println(subarraySum(sums, 2));

    }
    public static int subarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length];
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
            if(sum==k){
                count++;
            }
        }

        for (int i = 1; i < sums.length; i++) {
            for (int j = i; j < sums.length; j++) {
                if(sums[j] - sums[i-1] == k){
                    count ++;
                }
            }
        }
        return count;
    }
}
