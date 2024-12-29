package try_again.other_data_structure.priority_queue;

import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-10-21 10:39
 * 215.数组中第k大的元素
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int e : nums){
            pq.offer(e);

            //当k中元素多于k 时 去掉堆顶的最小元素
            if (pq.size() > k){
                pq.poll();
            }

        }

        return pq.peek();
    }
}
