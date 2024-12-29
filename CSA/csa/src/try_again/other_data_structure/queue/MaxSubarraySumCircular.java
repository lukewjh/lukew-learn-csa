package try_again.other_data_structure.queue;

/**
 * @author lukew
 * @create 2024-07-18 9:08
 * 918.环形子数组的最大和
 */
public class MaxSubarraySumCircular {

    public int maxSubarraySumCircular(int[] nums){

        int n = nums.length;

        int[] preSum = new int[2 * n + 1];

        preSum[0] = 0;

        for(int i = 1; i < preSum.length; i++){
            preSum[i] = preSum[i - 1] + nums[(i - 1) % n];
        }

        int maxSum = Integer.MIN_VALUE;

        MonotonicQueue<Integer> window = new MonotonicQueue<>();
        window.push(0);

        for(int i = 1; i < preSum.length; i++){
            maxSum = Math.max(maxSum, preSum[i] - window.min());
            if (window.size() == n){
                window.pop();
            }
            window.push(preSum[i]);

        }

        return maxSum;

    }
}
