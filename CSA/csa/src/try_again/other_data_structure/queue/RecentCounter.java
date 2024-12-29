package try_again.other_data_structure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lukew
 * @create 2024-06-14 8:34
 * 933.最近的请求次数
 */
public class RecentCounter {


    Queue<Integer> q = new LinkedList<>();

    public int ping(int t){

        q.offer(t);
        while(q.peek() < t - 3000){
            q.poll();
        }

        return q.size();

    }
}
