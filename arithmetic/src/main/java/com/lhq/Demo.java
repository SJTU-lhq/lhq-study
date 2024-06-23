package com.lhq;

import java.util.*;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/1/13 15:35
 */
public class Demo {
    public static void main(String[] args) {
/*        List<Integer> values = new ArrayList<>();
        String str = "123";
        char[] charArray = str.toCharArray();
        charArray[2] = 'a';
        String s = new String(charArray);
        System.out.println(s);
        Map<Character, Integer> charCountMap = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        Set<String> keySet = map.keySet();
        char[] sArry = str.toCharArray();
        int i = Integer.MIN_VALUE;*/
/*        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        maxSlidingWindow(nums, k);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.removeLast();
        queue.peekLast();*/
        isPerfectSquare(2147483647);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        int[] result = new int[size - k + 1];
        for (int i = 0; i < size - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            result[i] = max;
        }
        return result;
    }

    public static int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        int left = 1;
        int right = x;
        while (left <= right){
            //防止left+right超过int范围
            int mid = left + (right - left) / 2;
            if(mid > x / mid){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1){
            return true;
        }
        int left = 1;
        int right = num;
        while (left <= right){
            //防止left+right超过int范围
            int mid = left + (right - left) / 2;
            long result = mid * mid;
            if(result > num){
                right = mid - 1;
            }else if(result < num){
                left = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
