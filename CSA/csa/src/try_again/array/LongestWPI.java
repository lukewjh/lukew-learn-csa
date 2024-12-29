package try_again.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-04-22 17:18
 * 1124.表现良好的最长时间段
 */
public class LongestWPI {

    public int longestWPI(int[] hours){

        int n = hours.length;

        int[] preSum = new int[n + 1];
        preSum[0] = 0;

        Map<Integer,Integer> valtoIndex = new HashMap<>();

        int res = 0;

        for(int i = 1; i <= n; i++){
            //将8小时以上的时间 比作1  8小时以下比作-1  寻找相加后>0的子数组
            preSum[i] = preSum[i - 1] + (hours[i - 1] > 8 ? 1:-1);

            if (!valtoIndex.containsKey(preSum[i])){
                valtoIndex.put(preSum[i],i);
            }


            if (preSum[i] > 0){
                res = Math.max(i,res);
            }else{
                //preSum[i] 为负  需要寻找一个j使得preSum[i] - preSum[j] > 0
                //考虑到相邻元素的差的绝对值是1
                //那就需要找到preSum[j] == preSum[i] - 1, nums[j+1..i] 就是一个表现良好的时间段

                if (valtoIndex.containsKey(preSum[i] - 1)){
                    int j = valtoIndex.get(preSum[i] - 1);
                    res = Math.max(res,i-j);
                }
            }
        }


        return res;




    }
}
