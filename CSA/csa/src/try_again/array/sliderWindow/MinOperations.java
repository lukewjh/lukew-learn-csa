package try_again.array.sliderWindow;

/**
 * @author lukew
 * @create 2024-04-26 10:29
 * 1658.将 x 减到 0 的最小操作数
 */
public class MinOperations {

    public int minOperations(int[] nums, int x ){
        //找出最小操作数 也就是窗口滑到元素和 =  sum-x时
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++){
            sum += nums[i];
        }

        //滑动窗口需要寻找的子数组的和
        int target = sum - x;

        int left = 0;
        int right = 0;

        //记录窗口内所有元素和
        int windowSum = 0;
        //记录目标子数组的最大长度
        int maxLen = Integer.MIN_VALUE;

        while(right < nums.length){
            //扩大窗口
            windowSum += nums[right];
            right++;

            while(left < right && windowSum > target){
                windowSum -= nums[left];
                left++;
            }

            //寻找目标子数组
            if (windowSum == target){
                maxLen = Math.max(maxLen,right - left);
            }


        }

        //满足条件的滑动窗口子数组的和 可以推导出需要删除的字符数量
        return maxLen == Integer.MIN_VALUE ? -1 : n - maxLen;
    }
}
