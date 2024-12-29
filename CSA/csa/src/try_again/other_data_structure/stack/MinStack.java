package try_again.other_data_structure.stack;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-06-11 10:12
 * 155.最小栈
 */
public class MinStack {

    //维护A栈用来存数据，维护另一个B栈用来存A栈每次push时的最小值 以及pop时更新最小值
    Stack<Integer> stk = null;

    Stack<Integer> minStk = null;

    public MinStack(){
        stk = new Stack<>();
        minStk = new Stack<>();
    }

    public void push(int val){

        stk.push(val);
        //当MinStack为空或者需要存入的值比MinStack更小
        if(minStk.isEmpty() || val <= minStk.peek()){
            minStk.push(val);
        }
    }

    public void pop(){
        if (stk.peek().equals(minStk.peek())){
            minStk.pop();
        }
        stk.pop();
    }

    public int top(){
        return stk.peek();
    }

    public int getMin(){
        return minStk.peek();
    }
}
