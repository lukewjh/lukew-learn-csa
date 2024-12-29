package try_again.other_data_structure.stack;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-07-09 9:29
 * 计算nums中每个元素的下一个更大或相等的元素
 */
public class NextGreaterOrEqualElement {

    int[] nextGreaterOrEqualElement(int[] nums){

        int n = nums.length;

        int[] res = new int[n];

        Stack<Integer> stk = new Stack<>();

        for(int i = n - 1; i >= 0; i--){
            while(!stk.isEmpty() && stk.peek() < nums[i]){
                stk.pop();
            }

            res[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i]);

        }

        return res;


    }
}
