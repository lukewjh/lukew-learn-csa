package linkedlist;

/**
 * @author lukew
 * @create 2024-02-28 15:00
 */
public class Main6 {


    public static void main(String[] args) {

        Node n1 = new Node(1,null);
        Node n2 = new Node(2,null);
        Node n3 = new Node(3,null);
        Node n4 = new Node(4,null);
        Node n5 = new Node(5,null);
        LinkedList linkedList = new LinkedList();
        linkedList.insertTail(n1);
        linkedList.insertTail(n2);
        linkedList.insertTail(n3);
        linkedList.insertTail(n4);
        linkedList.insertTail(n5);
        linkedList.printAll();
        //删除结点
        linkedList.deleteByNode(n2);
        linkedList.printAll();
    }


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
        public void insertTail(Node newNode){

            if (head == null){
                head = newNode;
                return;
            }

            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next=newNode;

        }

        //删除结点
        public void deleteByNode(Node n){

            if (n == head){
                head.next = null;
            }

            Node cur = head;
            while(cur != null && cur.next != null){
                if (cur.next == n){
                    break;
                }
                cur = cur.next;
            }

            cur.next = cur.next.next;

        }

        //打印
        public void printAll(){
            Node cur = head;
            while(cur != null){
                System.out.print(cur.val+"    ");
                cur = cur.next;
            }
            System.out.println();
        }
    }


}
