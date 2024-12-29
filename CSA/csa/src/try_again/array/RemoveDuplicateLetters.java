package try_again.array;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-05-11 9:32
 * 316.去除重复字母
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s){
        //使用栈 来保存先后顺序 再用boolean[] 来去重
        Stack<Character> stk = new Stack<>();

        //维护一个计数器 记录字符串中字符的数量
        int[] count = new int[256];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i)] ++;
        }

        boolean[] inStack = new boolean[256];

        for (char c : s.toCharArray()){
            //每遍历一个字符 count-1
            count[c]--;

            if (inStack[c]){
                continue;
            }

            //保持字典序
            while(!stk.isEmpty() && stk.peek() > c){
                if (count[stk.peek()] == 0){
                    break;
                }

                //如果字符串后面还有这个元素 则pop 并更新instack  以保持字典序
                inStack[stk.pop()] = false;

            }

            stk.push(c);
            inStack[c] = true;

        }

        //将栈弹出后得到 结果字符串
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }

        return sb.reverse().toString();

    }


}
