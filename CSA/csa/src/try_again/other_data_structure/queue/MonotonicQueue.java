package try_again.other_data_structure.queue;

import java.security.acl.LastOwnerException;
import java.util.LinkedList;

/**
 * @author lukew
 * @create 2024-07-16 10:19
 * 单调队列通用版
 */
public class MonotonicQueue<E extends Comparable<E>> {

    //常规队列 存储所有元素
    LinkedList<E> q = new LinkedList<>();

    //元素降序排列的队列 头部是最大值
    LinkedList<E> maxq = new LinkedList<>();

    //元素升序排列的单调队列，头部是最小值
    LinkedList<E> minq = new LinkedList<>();


    public void push(E elem){

        //维护常规队列
        q.addLast(elem);

        //维护maxq
        while(!maxq.isEmpty() && maxq.getLast().compareTo(elem) < 0){
            maxq.pollLast();
        }
        maxq.addLast(elem);

        //维护minq
        while(!minq.isEmpty() && minq.getLast().compareTo(elem) > 0){
            minq.pollLast();
        }
        minq.addLast(elem);


    }

    public E max(){
        return maxq.getFirst();
    }

    public E min(){
        return minq.getFirst();
    }

    public E pop(){

        //弹出标准队列的头部元素
        E deleteVal = q.pollFirst();
        assert deleteVal != null;

        //由于push的时候可能会删除元素 deleteVal可能已经被删除了
        if (deleteVal.equals(maxq.getFirst())){
            maxq.pollFirst();
        }
        if (deleteVal.equals(minq.getFirst())){
            minq.pollFirst();
        }

        return deleteVal;

    }


    public int size(){
        return q.size();
    }

    public boolean isEmpty(){
        return q.isEmpty();
    }


}


