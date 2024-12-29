package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

/**
 * @author lukew
 * @create 2024-04-01 13:15
 * 删除有序链表中含有重复结点的所有结点
 */
public class DeleteDuplicates2 {


    public ListNode deleteDuplicates2(ListNode head){

        ListNode dummy = new ListNode(-1,null);
        ListNode p = dummy,q = head;
        while(q != null){
            if (q != null && q.val == q.next.val){
                //看看后面还有多少的相同的
                while(q != null && q.val == q.next.val){
                    q = q.next;
                }

                q = q.next;

                if (q == null){
                    p.next = null;
                }
            }else{
                //不是重复结点的话就接到dummy后
                p.next = q;
                p = p.next;
                q = q.next;

            }

        }

        return dummy.next;

    }
}
