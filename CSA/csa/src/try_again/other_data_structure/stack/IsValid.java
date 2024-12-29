package try_again.other_data_structure.stack;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-06-06 14:31
 * 20.判断括号是否有效
 */
public class IsValid {

    public boolean isValid(String str){

        Stack<Character> left = new Stack<>();

        for(char c : str.toCharArray()){
            //遇到左括号加入left
            if (c == '(' || c == '{' || c == '['){
                left.push(c);
            }else{
                if(!left.isEmpty() && leftOf(c) == left.peek()){
                    left.pop();
                }else{
                    return false;
                }
            }
        }
        return left.isEmpty();

    }

    char leftOf(char c){
        if(c == '}'){
            return '{';
        }
        if(c == ')'){
            return '(';
        }
        return '[';

    }
}
