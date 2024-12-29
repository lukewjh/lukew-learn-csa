package try_again.other_data_structure.stack;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-07-08 15:40
 * 503.下一个更大元素II
 */
public class NextGreaterElement3 {

    int[] nextGreaterElement3(int[] nums){

        int n = nums.length;
        int[] res = new int[n];

        Stack<Integer> s = new Stack<>();

        //数组长度加倍模拟环形数组
        for(int i = 2 * n - 1; i >= 0; i--){
            //索引需要求模
            while(!s.isEmpty() && s.peek() <= nums[i % n]){
                s.pop();
            }

            res[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }
        return res;

    }
}
