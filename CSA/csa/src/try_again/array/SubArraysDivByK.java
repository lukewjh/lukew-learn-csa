package try_again.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-04-22 14:25
 * 974.和被k整除的子数组
 */
public class SubArraysDivByK {

    public int subArraysDivByK(int[] nums, int k){

        int n = nums.length;

        int[] preSum = new int[n + 1];

        //前缀和余数的计数器
        Map<Integer,Integer> remainderToCount = new HashMap<>();

        preSum[0] = 0;
        remainderToCount.put(0,1);

        int res = 0;

        for (int i = 0; i < n; i++){
            preSum[i + 1] = preSum[i] + nums[i];

            //nums[0...i] 元素和与k的余数
            int curRemainder = preSum[i + 1] % k;

            //考虑为负数的情况
            if (curRemainder < 0){
                curRemainder += k;
            }

            //看看之前num[0...i-1]中是否存在前缀和余数为curRemainder的子数组
            if (remainderToCount.containsKey(curRemainder)){
                //如果存在 证明找到了可以整除k的子数组 累加子数组
                int count = remainderToCount.get(curRemainder);
                res += count;
                remainderToCount.put(curRemainder,count + 1);
            }else{
                //如果不存在  那么nums[0...i]是第一个前缀和余数为curRemainder的子数组
                remainderToCount.put(curRemainder,1);
            }
        }

        return res;

    }
}
