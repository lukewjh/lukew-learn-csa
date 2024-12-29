package linkedlist;

/**
 * @author lukew
 * @create 2024-02-19 11:15
 */

/**
 * 结点对象
 */
class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}


/**
 * 链表
 */
class LinkedList{
    Node head;

    public LinkedList(){
        this.head = null;
    }

    //向链表中添加元素
    public void appendAfter(int data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
            return ;
        }else{
            //遍历到最后的结点
            Node last = head;
            while(last.next != null){
                last = last.next;
            }

            last.next = newNode;

        }
    }


    //打印链表
    public void printAll(){
        if (head == null){
            System.out.println("链表为空");
        }

        Node current = head;
        while(current != null){
            System.out.println(current.data + "  ");
            current = current.next;
        }
        System.out.println();
    }

    //将链表的末结点指向指定位置的结点 形成环
    public void makeCircle(int pos){

        int count = 0;
        Node last = head;
        Node posNode = null;
        while (last != null){

            //找到pos对应的结点
            if (pos == count){
                posNode = last;
            }
            if (last.next == null){
                last.next = posNode;
                return ;
            }else{
                last = last.next;
            }
            count++;
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

    //检测链表中是否有环
    public boolean checkCircle(){

        if (head == null ) return false;

        //定义 快慢指针
        Node fast = head.next;
        Node slow = head;

        //遍历链表 当两个指针指的结点相同时  则表示有环
        while(fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                return true;
            }
        }

        return false;
    }


}



public class Main {


    public static void main(String[] args) {

        LinkedList link = new LinkedList();
        link.appendAfter(1);
        link.appendAfter(2);
        link.appendAfter(3);
        link.appendAfter(4);

        link.printAll();

        link.reverse();
        link.printAll();

        //循环链表判断
        LinkedList circleLink = new LinkedList();
        circleLink.appendAfter(1);
        circleLink.appendAfter(2);
        circleLink.appendAfter(3);
        circleLink.appendAfter(4);
        //使最后一个结点指向第一个结点
        circleLink.makeCircle(5);

//        circleLink.printAll();
        System.out.println(circleLink.checkCircle());

    }


}
