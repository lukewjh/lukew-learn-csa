package try_again.other_data_structure.priority_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-10-23 9:16
 * 347.前k个高频元素 （优先级队列法）
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k){

        HashMap<Integer,Integer> valToFreq = new HashMap<>();

        for(int v : nums){
            valToFreq.put(v, valToFreq.getOrDefault(v, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((entry1, entry2) -> {
            return entry1.getValue().compareTo(entry2.getValue());
        });

        for(Map.Entry<Integer,Integer> entry : valToFreq.entrySet()){
            pq.offer(entry);
            if (pq.size() > k){
                pq.poll();
            }
        }

        int[] res = new int[k];
        for(int i = k - 1; i >= 0; i--){
            res[i] = pq.poll().getKey();
        }

        return res;

    }
}
