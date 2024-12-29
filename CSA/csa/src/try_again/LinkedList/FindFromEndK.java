package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

/**
 * @author lukew
 * @create 2024-03-29 14:09
 * 查找倒数第k个结点
 */
public class FindFromEndK {

    /**
     * 删除倒数第n个结点
     * @param head
     * @param n
     * @return
     */
    ListNode delEndKth(ListNode head,int n){
        //删除倒数第n个结点 先找到倒数第n+1个结点
        ListNode dummy = new ListNode(-1,null);

        dummy.next = head;
        ListNode endkth = findFromEndKth(dummy, n + 1);
        endkth.next = endkth.next.next;
        return dummy.next;

    }


    ListNode findFromEndKth(ListNode head,int k){

        //思路：先让p1走k步  再让p2指向head 同时走到 p1走完  刚好就是倒数第k个

        ListNode p1 = head;
        //先走k步
        for (int i = 0;i < k; i++){
            p1 = p1.next;
        }

        //创建p2指向head  然后同时走 n-k步
        ListNode p2 = head;
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;

    }

}
