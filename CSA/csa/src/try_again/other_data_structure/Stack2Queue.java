package try_again.other_data_structure;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-06-06 9:59
 * 232.用栈实现队列
 */
public class Stack2Queue {

    //使用双栈实现一个队列
    private Stack<Integer> s1, s2;

    public Stack2Queue(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x){
        //push的时候将元素全部存到s1栈中
        s1.push(x);
    }

    public int pop(){
        //先调用peek保证非空
        peek();
        return s2.pop();
    }

    public int peek(){
        //在peek的时候 如果s2栈为空 则将s1栈中的元素全部放入s2中
        if (s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty(){
        return s1.isEmpty() && s2.isEmpty();
    }
}
