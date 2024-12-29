package try_again.other_data_structure.priority_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lukew
 * @create 2024-10-21 10:45
 * 451.根据字符出现频率排序
 */
public class FrequencySort {

    public String frequencySort(String s){

        char[] chars = s.toCharArray();

        HashMap<Character,Integer> charToFreq = new HashMap<>();

        for(char ch : chars){
            charToFreq.put(ch, charToFreq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((entry1, entry2) -> {
            return entry2.getValue().compareTo(entry1.getValue());
        });

        for(Map.Entry<Character,Integer> entry : charToFreq.entrySet()){
            pq.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.poll();
            Integer count = entry.getValue();
            String part = String.valueOf(entry.getKey());
            for(int i = 1; i <= count - 1; i++){
                part += part;
            }

            sb.append(part);
        }

        return sb.toString();

    }
}
