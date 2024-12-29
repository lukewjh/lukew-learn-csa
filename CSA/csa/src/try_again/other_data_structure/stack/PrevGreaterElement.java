package try_again.other_data_structure.stack;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-07-09 13:19
 * 上一个更大的元素
 */
public class PrevGreaterElement {

    //与找到下一个元素不同的是 上一个需要改变stack存放的顺序

    int[] prevGreaterElement(int[] nums){

        int n = nums.length;

        int[] res = new int[n];

        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && stk.peek() <= nums[i]){
                stk.pop();
            }

            res[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums[i]);

        }
        return res;

    }
}
