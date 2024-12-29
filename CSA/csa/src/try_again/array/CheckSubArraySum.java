package try_again.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-04-22 10:21
 * 523.连续的子数组和
 */
public class CheckSubArraySum {

    public boolean checkSubArraySum(int[] nums,int k){

        int n = nums.length;
        int[] preSum = new int[n + 1];

        preSum[0] = 0;
        for(int i = 1; i <= n; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }

        //找到连续子数组和等于k的倍数 就是理解为前缀和(preSum[j] - preSum[i])%k==0  也等同于 preSum[i]%k == preSum[j]%k
        //每个前缀和k的余数存起来
        Map<Integer,Integer> valToIndex = new HashMap<>();
        for(int i = 0;i < preSum.length; i++){
            int val = preSum[i] % k;

            if (!valToIndex.containsKey(val)){
                valToIndex.put(val,i);
            }
            //因为计算最大的长度 所以已经存过的余数就不存了

        }

        for (int i = 1; i < preSum.length; i++){
            int need = preSum[i] % k;
            if (valToIndex.containsKey(need)){
                if (i - valToIndex.get(need) >= 2){
                    return true;
                }
            }
        }

        return false;

    }


}
