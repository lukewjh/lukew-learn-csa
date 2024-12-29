package try_again.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-04-18 9:16
 * 525.连续数组
 */
public class FindMaxLength {


    public int findMaxLength(int[] nums){

        int n = nums.length;
        int[] preSum = new int[n + 1];

        preSum[0] = 0;

        for(int i = 1;i <= n; i++){
            preSum[i] = (nums[i-1]==0?-1:1) + preSum[i-1];
        }


        Map<Integer,Integer> valToIndex = new HashMap<>();

        int res = 0;
        for(int i = 0; i < preSum.length; i++){
            if (!valToIndex.containsKey(preSum)){
                valToIndex.put(preSum[i],i);
            }else{
                res = Math.max(res, i - valToIndex.get(preSum[i]));
            }

        }

        return res;
    }
}
