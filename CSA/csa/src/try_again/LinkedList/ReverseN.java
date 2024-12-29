package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

/**
 * @author lukew
 * @create 2024-04-07 11:12
 * 1.反转前N个结点
 * 2.反转链表的部分
 */
public class ReverseN {

    ListNode successor = null;

    public ListNode reverseN(ListNode head,int n){
        if (n == 1){
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head,int m,int n){
        //反转区间 [m.n]
        //当m=1时  就是反转前n个结点
        if (m == 1){
            return reverseN(head,n);
        }

        head.next = reverseBetween(head,m-1,n-1);
        return head;
    }
}
