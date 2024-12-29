package try_again.other_data_structure.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lukew
 * @create 2024-12-03 11:13
 * 计算器实现 拆解开来 1.先实现加减法（将算式看成由 符号+数字 为一部分组成） 2.实现乘除优先(碰到乘除时先弹出算) 3.实现括号优先（碰到括号时使用递归算）
 */
public class Calculator {

    public int calculate(String s){

        Map<Integer,Integer> rightIndex = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                rightIndex.put(stack.pop(), i);
            }
        }

        return _calculate(s, 0, s.length() - 1, rightIndex);
    }

    private int _calculate(String s, int start, int end, Map<Integer,Integer> rightIndex){
//                                             1 - 12 + 3
        Stack<Integer> stk = new Stack<>();

        int num = 0;

        char sign = '+';

        for(int i = start; i <= end; i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = 10 * num + (c - '0');
            }

            if (c == '('){
                num = _calculate(s, i + 1, rightIndex.get(i) - 1, rightIndex);
                i = rightIndex.get(i);
            }

            if(c == '+' || c == '-' || c == '*' || c == '/' || i == end){
                int pre;
                switch(sign){
                    case '+':
                        stk.push(num);
                        break;
                    case '-':
                        stk.push(-num);
                        break;
                    case '*':
                        pre = stk.pop();
                        stk.push(pre * num);
                        break;
                    case '/':
                        pre = stk.pop();
                        stk.push(pre / num);
                        break;
                }
                sign = c;
                num = 0;
            }

        }

        int res = 0;
        while(!stk.isEmpty()){
            res += stk.pop();
        }
        return res;
    }

}
