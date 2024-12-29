package try_again.other_data_structure.priority_queue;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author lukew
 * @create 2024-10-23 10:26
 *
 *347.前k个高频元素（计数排序法）
 */
public class TopKFrequent2 {

    public int[] topKFrequent(int[] nums, int k){

        HashMap<Integer,Integer> valToFreq = new HashMap<>();
        for(int v : nums){
            valToFreq.put(v, valToFreq.getOrDefault(v, 0) + 1);
        }

        ArrayList<Integer>[] freqToVals = new ArrayList[nums.length + 1];
        for(int val : valToFreq.keySet()){
            int freq = valToFreq.get(val);
            if (freqToVals[freq] == null){
                freqToVals[freq] = new ArrayList<>();
            }

            freqToVals[freq].add(val);
        }

        int[] res = new int[k];
        int p = 0;
        for(int i = freqToVals.length - 1; i > 0; i--){
            ArrayList<Integer> valList = freqToVals[i];
            if (valList == null){
                continue;
            }

            for(int j = 0; j < valList.size(); j++){
                res[p] = valList.get(j);
                p++;
                if (p == k){
                    return res;
                }
            }
        }
        return null;

    }
}
