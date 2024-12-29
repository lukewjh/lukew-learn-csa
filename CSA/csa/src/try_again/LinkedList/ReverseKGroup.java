package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

/**
 * @author lukew
 * @create 2024-04-08 10:34
 * 25.K个一组的反转链表
 *
 */
public class ReverseKGroup {

    //链表反转 [a,b]的反转
    public ListNode reverse(ListNode a,ListNode b){
        ListNode pre,cur,next;
        pre = null;
        cur = a;
        next = a;
        while(cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //反转后的新头结点
        return pre;

    }



    public ListNode reverseKGroup(ListNode head,int k){

        if (head == null) return null;

        ListNode a = head,b = head;
        //找到k的区间 [a,b)
        for (int i = 0; i < k; i++){
            if (b == null){
                return head;
            }
            b = b.next;
        }

        //反转k区间
        ListNode newHead = reverse(a,b);
        //下一个k区间
        a.next = reverseKGroup(b,k);
        return newHead;

    }
}
