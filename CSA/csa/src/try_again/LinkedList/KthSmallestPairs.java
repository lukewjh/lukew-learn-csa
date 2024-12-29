package try_again.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-04-07 9:21
 * 373.查找和最小的k对数字
 */
public class KthSmallestPairs {

    public List<List<Integer>> kthSmallestPairs(int[] nums1,int[] nums2,int k){

        //使用优先级队列 最小堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return (a[0]+a[1]) - (b[0]+b[1]);
        });

        for (int i = 0; i<nums1.length;i++){
            pq.offer(new int[]{nums1[i],nums2[0],0});
        }

        List<List<Integer>> res = new ArrayList<>();

        while(!pq.isEmpty() && k>0){
            int[] cur = pq.poll();
            k--;
            int next_index = cur[2] + 1;
            if (next_index < nums2.length){
                pq.add(new int[]{cur[0],nums2[next_index],next_index});
            }
            List<Integer> pair = new ArrayList<>();
            pair.add(cur[0]);
            pair.add(cur[1]);
            res.add(pair);
        }

        return res;

    }
}