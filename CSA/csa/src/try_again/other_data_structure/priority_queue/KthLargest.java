package try_again.other_data_structure.priority_queue;

import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-10-22 10:37
 * 703.数据流中的第k大元素
 */
public class KthLargest {


    private int k;
    private PriorityQueue<Integer> pq = new PriorityQueue<>();

    public KthLargest(int k, int[] nums){
        //将nums装入小顶堆 保留前k大的元素
        for(int e : nums){
            pq.offer(e);
            if(pq.size() > k){
                pq.poll();
            }
        }
        this.k = k;

    }


    public int add(int val){

        pq.offer(val);
        if (pq.size() > k){
            pq.poll();
        }
        return pq.peek();

    }
}
