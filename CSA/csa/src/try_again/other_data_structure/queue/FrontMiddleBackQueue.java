package try_again.other_data_structure.queue;

import java.util.LinkedList;

/**
 * @author lukew
 * @create 2024-06-18 9:13
 *
 * 1670.设计前中后队列
 */
public class FrontMiddleBackQueue {


    //用两个列表表示队列的左右两部分 以便从中间操作元素
    LinkedList<Integer> left = new LinkedList<>();
    LinkedList<Integer> right = new LinkedList<>();


    //如果是奇数个元素，维护左边少右边多，所以
    //1.如果有偶数个元素时，pushMiddle优先向右边添加
    //2.如果有奇数个元素时，popMiddle优先从右边删除
    //3.如果只有1个元素，popFront的时候，要去右边删除
    //要把以上三个特点写到代码里，才能保证细节不会出错

    //维护左边少 右边多的状态，每次增删元素之后都要执行
    private void balance(){
        //右边最多比左边多一个元素
        if (right.size() > left.size() + 1){
            left.addLast(right.removeFirst());
        }

        if (left.size() > right.size()){
            //左边多，给右边一个
            right.addFirst(left.removeLast());
        }
    }

    public void pushFront(int val){
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val){
        //如果有偶数个元素时  往右边添加
        if(size() % 2 == 0){
            right.addFirst(val);
        }else{
            left.addLast(val);
        }

        balance();

    }

    public void pushBack(int val){
        right.addLast(val);
        balance();
    }

    public int popFront(){
        if(size() == 0){
            return -1;
        }

        if (size() == 1){
            return right.removeFirst();
        }

        int e = left.removeFirst();
        balance();
        return e;
    }


    public int popMiddle(){
        if (size() == 0){
            return -1;
        }


        int e;
        if (size() % 2 == 0){
            e = left.removeLast();
        }else{
            e = right.removeFirst();
        }

        balance();
        return e;
    }

    public int popBack(){
        if (size() == 0){
            return -1;
        }
        int e = right.removeLast();
        balance();
        return e;
    }



    public int size(){
        return left.size() + right.size();
    }

}
