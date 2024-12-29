package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

/**
 * @author lukew
 * @create 2024-03-29 17:50
 * 求相交链表的交点
 */
public class IntersectionNode {

    ListNode getIntersectionNode(ListNode headA,ListNode headB){

        //思路：遍历完A就遍历B  相等时证明相交且是交点
        ListNode p1 = headA,p2 = headB;
        while (p1 != p2){
            //p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null){
                p1 = headB;
            }else{
                p1 = p1.next;
            }
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null){
                p2 = headA;
            }else{
                p2 = p2.next;
            }

        }
        return p1;

    }

}
