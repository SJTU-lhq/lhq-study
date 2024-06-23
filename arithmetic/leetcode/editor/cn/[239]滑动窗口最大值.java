//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2668 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length;
        int m = size - k + 1;
        int[] result = new int[m];
        //队列存的是下标
        LinkedList<Integer> list = new LinkedList<>();

        for (int right = 0 ; right < size; right++) {
            //队列不为空 且 总右边数的第一个 比要加入的数字小，都要移除
            while (!list.isEmpty() && nums[right] >= nums[list.peekLast()]) {
                list.removeLast();
            }
            //记录下标
            list.addLast(right);

            //窗口左边界
            int left = right - k + 1;
            //当窗口左边界大于了 队列队首元素的下标时，表示该元素已经不在队列里，要移除
            if(list.peekFirst() < left){
                list.removeFirst();
            }
            //当left >= 0时表示已经全部在数组中，开始记录
            if(left >= 0){
                result[left] = nums[list.peekFirst()];
            }
        }

        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
