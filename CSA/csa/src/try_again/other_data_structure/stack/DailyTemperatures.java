package try_again.other_data_structure.stack;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-07-08 14:51
 * 739.每日温度
 */
public class DailyTemperatures {

    int[] dailyTemperatures(int[] temperatures){

        int n = temperatures.length;

        int[] res = new int[n];

        //在栈中放入元素索引 而不是元素
        Stack<Integer> s = new Stack<>();

        for(int i = n - 1; i >= 0; i--){

            while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]){
                s.pop();
            }

            //获得索引的间距
            res[i] = s.isEmpty() ? 0 : (s.peek() - i);
            s.push(i);
        }

        return res;
    }
}
