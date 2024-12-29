package try_again.array;

/**
 * @author lukew
 * @create 2024-04-17 11:31
 *
 * 724.寻找数组的中心下标
 */
public class PivotIndex {

    public int pivotIndex(int[] nums){

        int n = nums.length;
        //构建前缀和
        int[] preSum = new int[n];
        preSum[0] = 0;
        for(int i = 1;i <= n; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }

        //根据前缀和判断左半边和右半边数组元素和是否相同
        for(int i = 1;i < preSum.length; i++){
            int leftSum = preSum[i - 1] - preSum[0];
            int rightSum = preSum[n] - preSum[i];

            if (leftSum == rightSum){
                return i - 1;
            }
        }

        return -1;

    }
}
