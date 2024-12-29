package try_again.other_data_structure.queue;

/**
 * @author lukew
 * @create 2024-07-17 8:59
 * 1438.绝对差不超过限制的最长连续子数组
 */
public class LongestSubArray {

    public int longestSubArray(int[] nums, int limit){

        //滑动窗口加 单调队列
        int left = 0;
        int right = 0;

        int windowSize = 0;
        int res = 0;

        //单调队列
        MonotonicQueue<Integer> window = new MonotonicQueue<>();

        while(right < nums.length){
            //扩大窗口
            window.push(nums[right]);

            right++;

            windowSize++;

            while(window.max() - window.min() > limit){
                window.pop();
                left++;
                windowSize--;
            }

            res = Math.max(res, windowSize);
        }
        return res;

    }

}
