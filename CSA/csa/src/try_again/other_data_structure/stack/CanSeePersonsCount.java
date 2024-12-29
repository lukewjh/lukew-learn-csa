package try_again.other_data_structure.stack;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-07-10 9:05
 * 1944.队列中可以看到的人数
 */
public class CanSeePersonsCount {

    int[] canSeePersonsCount(int[] heights){

        int n = heights.length;

        int[] res = new int[n];

        Stack<Integer> stk = new Stack<>();

        for(int i = n - 1; i >= 0; i--){

            int count = 0;
            while(!stk.isEmpty() && heights[i] > stk.peek()){
                stk.pop();
                count++;
            }

            res[i] = stk.isEmpty() ? count : count + 1;
            stk.push(heights[i]);

        }
        return res;

    }
}
