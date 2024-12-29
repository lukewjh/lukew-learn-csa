package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

/**
 * @author lukew
 * @create 2024-04-01 10:27
 *
 * 删除有序链表中的重复结点
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head){

        if (head == null) return null;
        ListNode fast = head,slow = head;

        //遍历链表，直到碰到不同的时候 将慢指针的next结点指向快指针  再更新慢指针
        while(fast != null){
            if (fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        //断开与后面重复连接的元素

        return head;

    }

}
