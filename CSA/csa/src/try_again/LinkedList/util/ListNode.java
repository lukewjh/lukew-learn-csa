package try_again.LinkedList.util;

import java.util.List;

/**
 * @author lukew
 * @create 2024-03-28 17:01
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
