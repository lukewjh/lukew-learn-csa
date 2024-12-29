package try_again.other_data_structure.queue;

/**
 * @author lukew
 * @create 2024-07-17 16:52
 * 862.和至少为k的最短子数组
 */
public class ShortestSubarray {

    public int shortestSubarray(int[] nums, int k){

        int n = nums.length;

        long[] preSum = new long[n + 1];

        preSum[0] = 0;

        for(int i = 1; i <= n; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        MonotonicQueue<Long> window = new MonotonicQueue<>();
        int right = 0;
        int left = 0;
        int len = Integer.MAX_VALUE;

        while(right < preSum.length){
            window.push(preSum[right]);
            right++;

            while(right < preSum.length && !window.isEmpty() && preSum[right] - window.min() >= k){
                len = Math.min(len,right - left);
                window.pop();
                left++;
            }

        }

        return len == Integer.MAX_VALUE ? -1 : len;

    }
}
