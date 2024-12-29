package try_again.other_data_structure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lukew
 * @create 2024-06-14 8:55
 * 346.数据流中的移动平均值
 */
public class MovingAverage {

    //维护定长队列和队列中的元素和
    int maxSize = 0;
    int queueSum = 0;

    Queue<Integer> q = new LinkedList<>();

    public MovingAverage(int size){
        maxSize = size;
    }

    public double next(int val){

        if(q.size() == maxSize){
            int deletedVal = q.poll();
            queueSum -= deletedVal;
        }

        q.offer(val);
        queueSum += val;

        return (double) queueSum / q.size();

    }
}
