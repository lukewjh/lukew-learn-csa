package try_again.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-04-22 11:20
 * 560.和为k的子数组（个数）
 */
public class SubArraySum {


    public int subArraySum(int[] nums, int k){

        int n = nums.length;

        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        //前缀和到该前缀和出现次数的映射
        Map<Integer,Integer> count = new HashMap<>();
        count.put(0,1);

        //记录和为k的子数组个数
        int res = 0;
        for(int i = 1;i <= n; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];

            int need = preSum[i] - k;

            if (count.containsKey(need)){
                res += count.get(need);
            }

            //将当前前缀存入哈希表  已存在的前缀和则+1后存储
            if (!count.containsKey(preSum[i])){
                count.put(preSum[i],1);
            }else{
                count.put(preSum[i],count.get(preSum[i] + 1));
            }

        }

        return res;

    }

}
