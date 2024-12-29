package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

/**
 * @author lukew
 * @create 2024-03-29 9:11
 * 对比x的值 分割链表
 */
public class PartionList {




    ListNode partition(ListNode head,int x){
        ListNode dummy1 = new ListNode(-1,null);
        ListNode dummy2 = new ListNode(-1,null);

        ListNode p = head;
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        while(p != null){
            if (p.val < x){
                p1.next = p;
                p1 = p1.next;
            }else{
                p2.next = p;
                p2.next = p2.next;
            }

            //当把当前的p赋值给p1或者p2后  当前p的节点需要断开  不然p1或者p2就和p连起来了
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }

        p1.next = dummy2.next;

        return dummy1.next;

    }

}
