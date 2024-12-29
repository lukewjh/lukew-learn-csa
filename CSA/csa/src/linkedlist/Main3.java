package linkedlist;

/**
 * @author lukew
 * @create 2024-02-19 13:08
 */
public class Main3 {


    //结点类

    static class Node{
        int value;
        Node next;

        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }

    //链表

    static class LinkedList{
        Node head;

        //末尾添加
        public void appendAfter(int value){

            Node node = new Node(value, null);

            if (head == null){
                head = node;
                return;
            }

            Node last = head;
            while(last.next != null){
                last = last.next;
            }

            last.next = node;

        }

        public void printAll (){
            if (head == null) {
                System.out.println("链表为空");
                return;
            }

            Node cur = head;
            while(cur != null){
                System.out.println(cur.value + "    ");
                cur = cur.next;
            }


        }


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

        link.appendAfter(1);
        link.appendAfter(2);
        link.appendAfter(3);
        link.appendAfter(4);

        link.printAll();

        link.reverse();
        link.printAll();

    }
}
