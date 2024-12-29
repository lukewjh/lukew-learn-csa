package linkedlist;

/**
 * @author lukew
 * @create 2024-02-20 8:56
 */
public class Main4 {


     static class Node{
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

     static class LinkedList{

         Node head;

         //尾插
         public void appendAfter(int val){

             Node newNode = new Node(val,null);

             if (head == null){
                 head = newNode;
                 return ;
             }
             Node last = head;
             while(last.next != null){
                 last = last.next;
             }
             last.next = newNode;



         }

         //打印
         public void printAll(){

             Node cur = head;
             while(cur != null){
                 System.out.print(cur.val + "  ");
                 cur = cur.next;
             }

         }

         //翻转链表
         public void reverse(){

             Node cur = head;
             Node pre = null;

             while(cur != null){
                Node next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
             }
             head = pre;
         }

         public boolean checkCircle(){

             if (head == null) return false;

             Node fast = head.next;
             Node slow = head;
             while (fast != null && fast.next != null){
                 fast = fast.next.next;
                 slow = slow.next;

                 if (fast == slow){
                     return true;
                 }
             }

             return false;
         }



    }

    public static void main(String[] args) {
        LinkedList link = new LinkedList();
        link.appendAfter(1);
        link.appendAfter(2);
        link.appendAfter(3);
        link.appendAfter(4);
        link.appendAfter(5);

        link.printAll();
        link.reverse();
        link.printAll();

        System.out.println(link.checkCircle());



    }
}




