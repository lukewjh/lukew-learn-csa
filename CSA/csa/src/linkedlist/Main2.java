package linkedlist;

/**
 * @author lukew
 * @create 2024-02-19 11:39
 */
public class Main2 {

    //结点对象
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

        //向链表末尾添加
        Node head;

        public void appendAfter(int value){
            Node newNode = new Node(value,null);

            if (head == null){
                head = newNode;
                return;
            }

            //遍历链表，将新结点放到最后
            Node last = head;
            while(last.next != null){
                last = last.next;
            }

            last.next = newNode;
        }

        public void printAll(){
            if (head == null) return;

            Node current = head;
            while(current != null){
                System.out.print(current.value + "  ");
                current = current.next;
            }

        }

        //链表翻转
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
        link.appendAfter(5);

        link.printAll();

        link.reverse();
        link.printAll();

    }
}


