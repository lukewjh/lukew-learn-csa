package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

/**
 * @author lukew
 * @create 2024-03-28 17:00
 * 合并两个有序单链表
 */
public class MergeSortedTwoList {

    ListNode mergeTwoList(ListNode l1,ListNode l2){

        //创建一个哨兵节点
        ListNode dummy = new ListNode(-1,null);
        ListNode p = dummy;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null){

            if (p1.val < p2.val){
                p.next = p1;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }

            p = p.next;
        }

        if (p1 != null){
            p.next = p1;
        }

        if (p2 != null){
            p.next = p2;
        }

        return dummy.next;

    }

}
