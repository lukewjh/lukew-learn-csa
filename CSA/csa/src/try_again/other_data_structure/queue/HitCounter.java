package try_again.other_data_structure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lukew
 * @create 2024-06-12 8:53
 * 362.敲击计数器
 */
public class HitCounter {

    Queue<Integer> q = new LinkedList<>();

    public void hit(int timestamp){
        q.offer(timestamp);
    }

    public int getHits(int timestamp){

        while(!q.isEmpty() && timestamp - q.peek() >= 300){
            q.poll();
        }

        return q.size();
    }
}
