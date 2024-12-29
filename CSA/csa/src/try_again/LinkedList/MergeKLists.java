package try_again.LinkedList;

import try_again.LinkedList.util.ListNode;

import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-03-29 10:36
 * 合并k个有序链表
 */
public class MergeKLists {

    //将数组中的所有链表保存到小根堆中 每次从里面获取一个最小的节点即可

    ListNode mergeKLists(ListNode[] lists){
        if (lists == null) return null;

        ListNode dummy = new ListNode(-1,null);
        ListNode p = dummy;

        //优先级队列  默认小根堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(a,b) -> (a.val - b.val));

        for (ListNode head : lists){
            if (head != null){
                pq.add(head);
            }
        }

        while(!pq.isEmpty()){
            //获取堆顶
            ListNode node = pq.poll();
            p.next = node;

            //将取出链表节点的next节点存入优先级队列中
            if (node.next != null){
                pq.add(node.next);
            }

            p = p.next;

        }

        return dummy.next;

    }


}
