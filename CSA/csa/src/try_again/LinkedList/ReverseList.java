package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

/**
 * @author lukew
 * @create 2024-04-07 9:48
 * 206.反转链表（递归）
 */
public class ReverseList {

    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode last = reverseList(head);
        head.next.next = head;
        head.next = null;

        return last;
    }
}
