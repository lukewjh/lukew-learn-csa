package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

/**
 * @author lukew
 * @create 2024-04-08 13:35
 * 234.判断单链表是否是回文链表
 */
public class IsPalindrome {


    /**
     * 使用后序遍历的特征来获得链表从尾向前的指针来对比
     */

    //左侧指针
    ListNode left;

    boolean isPalindrome(ListNode head){
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right){
        if (right == null){
            return true;
        }

        boolean res = traverse(right.next);

        //后序遍历的代码
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }


    /**
     * 使用快慢指针 找到链表中点解决 优化空间复杂度
     */
    boolean isPalindrome2(ListNode head){
        //找到中点  若fast指针最后遍历不到null 证明节点是奇数个 则slow需要再往后移一位
        if (head == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }



        //构建左右指针
        ListNode left = head;
        ListNode right = slow;
        //反转右指针开始的链表
        right = reverse(right);
        while(right != null){
            if (left.val != right.val){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;


    }

    public ListNode reverse(ListNode head){
        ListNode cur = head,pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }



}
