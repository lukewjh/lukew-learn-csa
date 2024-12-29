package try_again.other_data_structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lukew
 * @create 2024-06-06 10:23
 * 225.用队列实现栈
 */
public class Queue2Stack {

    Queue<Integer> q = new LinkedList<>();
    //记录队列内对应的队尾元素（栈顶）
    int top_elem = 0;

    //添加元素到栈顶
    public void push(int x){
        q.offer(x);
        top_elem = x;
    }

    //返回栈顶元素
    public int top(){
        return top_elem;
    }

    public int pop(){
        //pop就是将队列后面的元素移到前面去 实现栈顶效果
        int size = q.size();

        while(size > 2){
            q.offer(q.poll());
            size--;
        }

        top_elem = q.peek();
        q.offer(q.poll());
        return q.poll();
    }

    public boolean empty(){
        return q.isEmpty();
    }

}
