package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

/**
 * @author lukew
 * @create 2024-03-29 15:58
 *
 * 判断链表中是否有环
 */
public class HasCycle {

    boolean hasCycle(ListNode head){

        //fast走两步  slow走一步  如果相遇 则证明有环
        ListNode fast = head,slow=head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast){
                return true;
            }
        }


        return false;

    }

    /**
     * 判断是否有环 并返回环的起点
     */
    ListNode detectCycle(ListNode head){
        ListNode fast = head,slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                //有环
                break;
            }
        }
        //最后fast指向空的话就证明没有环 返回null
        if (fast == null || fast.next == null){
            return null;
        }


        //将相遇点的任意指针指向head  再同时相同步幅的走 相遇点就是环起点
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
