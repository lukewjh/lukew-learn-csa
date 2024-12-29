package queue;

/**
 * @author lukew
 * @create 2024-02-21 11:12
 */
public class LinkedQueueMain {


    //结点类
    static class Node{
        int val;
        Node next;


        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    static class LinkedQueue{


        Node head;
        Node tail;

        //入队
        public boolean enqueue(int val){
            //链式队列 无限大小 无需判断队满

            Node newNode = new Node(val,null);
            if (head == null){
                head = newNode;
                tail = newNode;
            }

            tail.next = newNode;
            tail = tail.next;

            return true;
        }

        //出队
        public int dequeue(){
            //队空判断
            if (tail == null){
                System.out.println("队空");
            }
            int val = head.val;
            head = head.next;
            return val;

        }

        public void printAll(){
            Node cur = head;
            while(cur != null){
                System.out.print(cur.val + "    ");
                cur = cur.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        LinkedQueue lq = new LinkedQueue();
        lq.enqueue(1);
        lq.enqueue(2);
        lq.enqueue(3);
        lq.enqueue(4);
        lq.enqueue(5);

        lq.printAll();

        System.out.println("出列的值" + lq.dequeue());

        lq.enqueue(6);

        lq.printAll();
    }
}
