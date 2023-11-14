package lhq.lhqstudy;

/**
 * @author lihaiquan (lihq@rd.netease.com)
 * @description:
 * @date 2023/9/4 16:57
 */
public class Demo {
        public static void main(String[] args) {
            // Scanner input=new Scanner(System.in);
            // String str=input.next();
            int[] nums = new int[]{1,2,3,3,3,4,4,5,7,7,7,9,10};
            System.out.println(getTimes(9, nums));
        }
        public static int getTimes(int num, int[] nums){
            int ans = 0;
            int l = 0;
            int r = nums.length-1;
            while(l<r){
                int mid = l + (r-l)/2;
                if(nums[mid]<num){
                    l = mid+1;
                }else if(nums[mid]>num){
                    r = mid -1;
                }else{
                    int start = findMin(nums, l, mid, num);
                    int end = findMax(nums, mid, r, num);
                    ans = end -  start + 1;
                    break;
                }
            }

            return ans;
        }

        public static int findMin(int[] nums, int l, int r, int target){
            while(l<r){
                int mid = l + (r-l)/2;
                if(nums[mid]==target){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            return l;
        }
        public static int findMax(int[] nums, int l, int r, int target){
            while(l<r){
                int mid = l + (r-l)/2;
                if(nums[mid]==target){
                    l = mid;
                }else{
                    r = mid -1;
                }
            }
            return l;
        }
}
