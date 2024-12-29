package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

/**
 * @author lukew
 * @create 2024-03-29 15:24
 * 找到链表的中间节点
 */
public class MiddleNode {

    //使用快慢指针 slow一步  fast两步  fast走完的时候刚好就是slow到链表一半的时候
    public ListNode getMiddleNode(ListNode head){
        ListNode slow = head,fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
