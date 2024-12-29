package try_again.other_data_structure.stack;

import try_again.LinkedList.util.ListNode;

import java.util.Stack;

/**
 * @author lukew
 * @create 2024-06-06 13:26
 * 143.重排链表
 */
public class ReorderList {

    public void reorderList(ListNode head){
        Stack<ListNode> stk = new Stack<>();
        //将所有节点放入栈中 得到反序链表
        ListNode p = head;
        while(p != null){
            stk.push(p);
            p = p.next;
        }

        p = head;

        while(p != null){

            //链表尾部的节点
            ListNode lastNode = stk.pop();

            ListNode next = p.next;

            if (lastNode == next || lastNode.next == next){
                //结束条件 链表节点为奇数或者偶数时均适用
                lastNode.next = null;
                break;
            }
            p.next = lastNode;
            lastNode.next = next;
            p = next;

        }

    }
}
