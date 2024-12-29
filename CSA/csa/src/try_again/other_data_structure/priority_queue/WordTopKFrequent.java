package try_again.other_data_structure.priority_queue;

import java.util.*;

/**
 * @author lukew
 * @create 2024-10-24 9:30
 * 692.前k个高频单词
 */
public class WordTopKFrequent {

    public List<String> topKFrequent(String[] words, int k){

        HashMap<String,Integer> wordToFreq = new HashMap<>();
        for(String word : words){
            wordToFreq.put(word,wordToFreq.getOrDefault(word,0) + 1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((entry1, entry2) -> {

            if (entry1.getValue().equals(entry2.getValue())){
                return entry2.getKey().compareTo(entry1.getKey());
            }

            return entry1.getValue().compareTo(entry2.getValue());

        });

        for(Map.Entry<String,Integer> entry : wordToFreq.entrySet()){
            pq.offer(entry);
            if (pq.size() > k){
                pq.poll();
            }
        }

        //把出现次数最多的k个字符串返回
        LinkedList<String> res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.addFirst(pq.poll().getKey());
        }

        return res;

    }
}
