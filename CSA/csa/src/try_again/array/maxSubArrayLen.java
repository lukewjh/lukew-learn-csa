package try_again.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-04-22 13:38
 * 325.和等于k的最长子数组长度
 */
public class maxSubArrayLen {

    public int maxSubArrayLen(int[] nums, int k){

        int n = nums.length;

        Map<Integer,Integer> preSumToIndex = new HashMap<>();


        int maxLen = 0;
        //简化前缀和数组为一个变量
        int preSum = 0;

        preSumToIndex.put(0,-1);

        for(int i = 0; i < n; i++){
            preSum += nums[i];

            preSumToIndex.putIfAbsent(preSum,i);

            int need = preSum - k;
            if (preSumToIndex.containsKey(need)){
                int j = preSumToIndex.get(need);

                maxLen = Math.max(maxLen,i - j);
            }
        }
        return maxLen;

    }
}
