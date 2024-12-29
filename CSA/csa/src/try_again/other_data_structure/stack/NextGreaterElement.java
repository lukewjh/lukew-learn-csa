package try_again.other_data_structure.stack;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-06-21 9:25
 * 单调栈
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums){
        int n = nums.length;

        int[] res = new int[n];

        Stack<Integer> s = new Stack<>();

        for(int i = n - 1; i >= 0; i--){
            //从后往前存入栈 就等于是从前往后获取了 然后碰到小的就弹出
            while(!s.isEmpty() && s.peek() <= nums[i]){
                s.pop();
            }

            //nums[i]身后更大的元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }
}
