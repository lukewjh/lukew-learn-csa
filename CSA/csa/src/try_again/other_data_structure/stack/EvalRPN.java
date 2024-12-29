package try_again.other_data_structure.stack;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-06-07 10:31
 * 150.逆波兰表达式求值
 */
public class EvalRPN {

    public int evalRPN(String[] tokens){

        Stack<Integer> stk = new Stack<>();

        for(String token : tokens){
            if ("+-*/".contains(token)){
                int a = stk.pop();
                int b = stk.pop();

                switch(token){
                    case "+":
                        stk.push(a + b);
                        break;
                    case "*":
                        stk.push(a * b);
                        break;
                    case "-":
                        stk.push(b - a);
                        break;
                    case "/":
                        stk.push(b / 2);
                        break;
                }
            }else{
                stk.push(Integer.parseInt(token));
            }

        }
        return stk.pop();

    }
}
