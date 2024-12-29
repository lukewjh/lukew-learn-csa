package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

import java.util.HashMap;

/**
 * @author lukew
 * @create 2024-04-01 13:48
 * 移除未排序链表中的重复元素
 */
public class DeleteDuplicatesUnsorted {


    public ListNode deleteDuplicatesUnsorted(ListNode head){

        //记录元素出现次数的hash表
        HashMap<Integer,Integer> count = new HashMap<>();

        ListNode p = head;
        while(p != null){
            count.put(p.val,count.getOrDefault(p.val,0));
            p = p.next;
        }

        ListNode dummy = new ListNode(-1,null);
        dummy.next = head;
        p = dummy;
        while(p != null){
            ListNode unique = p.next;
            while(unique != null && count.get(unique) > 1){
                unique = unique.next;
            }

            //接入不重复的结点或者是尾部null
            p.next = unique;
            //p前进，继续找不重复的结点
            p = p.next;

        }

        return dummy.next;

    }
}
