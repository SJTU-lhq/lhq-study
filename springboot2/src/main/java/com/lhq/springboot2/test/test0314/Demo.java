package com.lhq.springboot2.test.test0314;

/**
 * @author lihaiquan
 * @description:
 * @date 2024/3/14 20:01
 */
public class Demo {
    public static int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid -1;
                }else {
                    left = mid + 1;
                }
            }else {
                if(target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                }else {
                    right = mid -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,0,1,2,4,5,6};
        int search = search(nums, 0);
        System.out.println(search);
    }
}
