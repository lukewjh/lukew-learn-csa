package try_again.other_data_structure.stack;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-07-09 13:12
 * 下一个更小的元素
 */
public class NextLessElement {

    int[] nextLessElement(int[] nums){

        int n = nums.length;

        int[] res = new int[n];

        Stack<Integer> stk = new Stack<>();

        for(int i = n - 1; i >= 0; i--){
            //比当前大的都弹出
            while(!stk.isEmpty() && stk.peek() >= nums[i]){
                stk.pop();
            }

            res[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i]);
        }

        return res;

    }
}
