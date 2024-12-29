package try_again.other_data_structure.priority_queue;

import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-10-24 13:12
 * 1845.座位预约管理系统
 */
public class SeatManager {


    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public SeatManager(int n){
        for(int i = 1; i <= n; i++){
            pq.offer(i);
        }
    }

    public int reserve(){
        return pq.poll();
    }

    public void unreserve(int i){
        pq.offer(i);
    }


}
