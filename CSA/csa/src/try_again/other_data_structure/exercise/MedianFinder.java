package try_again.other_data_structure.exercise;

import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-12-04 9:42
 * 295.数据流中的中位数
 */
public class MedianFinder {

    //使用一个 大根堆 和一个 小根堆 叠放在一起 两个堆的大小差小于1 它两个的顶就是 中位数
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    public MedianFinder(){
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a,b) -> {
           return b - a;
        });
    }

    public double findMedian(){
        //如果元素不一样多 多的那个堆的堆顶就是中位数
        if(large.size() < small.size()){
            return small.peek();
        }else if (large.size() > small.size()){
            return large.peek();
        }
        //如果两个一样多 则两个堆顶相加除2
        return (large.peek() + small.peek()) / 2.0;
    }

    public void addNum(int num){
        if(small.size() >= large.size()){
            small.offer(num);
            large.offer(small.poll());
        }else{
            large.offer(num);
            small.offer(large.poll());
        }
    }








}
