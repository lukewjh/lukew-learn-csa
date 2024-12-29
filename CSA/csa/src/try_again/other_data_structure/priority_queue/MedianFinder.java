package try_again.other_data_structure.priority_queue;

import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-10-24 13:23
 *
 */
public class MedianFinder {

    //使用两个优先级队列
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;


    public MedianFinder(){
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a,b) -> {
           return b - a;
        });
    }

    public double findMedian(){
        //如果两个优先级队列的元素不是一样多的 那么多出来的那一个就是中位数
        if(large.size() < small.size()){
            return small.peek();
        }else if(large.size() > small.size()){
            return large.peek();
        }
        //那么碰到两个队列中的元素数量一样多的话 就是堆顶元素相加除2
        return (large.peek() + small.peek()) / 2.0;
    }

    public void addNum(int num){
        if (small.size() >= large.size()){
            small.offer(num);
            large.offer(small.poll());
        }else{
            large.offer(num);
            small.offer(large.poll());
        }
    }
}
