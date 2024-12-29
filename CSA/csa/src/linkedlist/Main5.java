package linkedlist;

/**
 * @author lukew
 * @create 2024-02-21 15:29
 */
public class Main5 {

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

        //头插
        public void insertHeader(int val){
            Node newNode = new Node(val,null);
            newNode.next = head;
            head = newNode;

        }

        //尾插
        public void insertTail(int val){

            Node newNode = new Node(val,null);
            if(head == null) {
                head = newNode;
                return ;
            }
            Node last = head;
            while( last.next != null ){
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
            System.out.println();
        }

        //翻转
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

    }

    public static void main(String[] args) {
        LinkedList link = new LinkedList();
        link.insertTail(1);
        link.insertTail(2);
        link.insertTail(3);

        link.printAll();

        link.insertHeader(4);
        link.printAll();

        link.reverse();
        link.printAll();
    }






}
