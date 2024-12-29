package try_again.other_data_structure.priority_queue;

import try_again.LinkedList.util.ListNode;

import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-10-16 9:06
 * 23.合并k个升序链表
 */
public class MergeKList {

    public ListNode mergeKList(ListNode[] lists){

        if(lists.length == 0){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        //优先级队列 默认小根堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(a,b) -> (a.val - b.val));

        //加入最小堆
        for(ListNode head : lists){
            if (head != null){
                pq.add(head);
            }
        }

        //逐步取出最小的堆顶
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;

            if (node.next != null){
                pq.add(node.next);
            }

            p = p.next;
        }

        return dummy.next;

    }
}
