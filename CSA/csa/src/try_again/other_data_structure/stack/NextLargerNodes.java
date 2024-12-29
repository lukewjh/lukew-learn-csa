package try_again.other_data_structure.stack;

import try_again.LinkedList.util.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author lukew
 * @create 2024-07-09 13:35
 */
public class NextLargerNodes {

    int[] nextLargerNodes(ListNode head){

        //将链表转换为数组 方便使用单调栈解决这个问题
        ArrayList<Integer> nums = new ArrayList<>();

        for(ListNode p = head; p != null; p = p.next){
            nums.add(p.val);
        }

        int[] res = new int[nums.size()];

        Stack<Integer> stk = new Stack<>();

        for(int i = nums.size() - 1; i >= 0; i--){

            while(!stk.isEmpty() && stk.peek() <= nums.get(i)){
                stk.pop();
            }

            res[i] = stk.isEmpty() ? 0 : stk.peek();
            stk.push(nums.get(i));

        }

        return res;

    }
}
