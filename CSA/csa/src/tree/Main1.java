package tree;

/**
 * @author lukew
 * @create 2024-03-28 10:00
 */
public class Main1 {

    public static void main(String[] args) {
        ListNode head = new ListNode(new ListNode(new ListNode(null,3),2),1);

        traverse(head);

    }


    static class ListNode{
        ListNode next;
        int val;

        public ListNode(ListNode next, int val) {
            this.next = next;
            this.val = val;
        }
    }

    static void print(int val){
        System.out.println(val);
    }


    static void traverse(ListNode head){
        if (head == null) return ;

        traverse(head.next);

        //后序位置 利用后序位置实现倒序打印链表
        print(head.val);
    }
}
