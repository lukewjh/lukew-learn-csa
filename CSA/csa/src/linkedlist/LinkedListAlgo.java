package linkedlist;

/**
 * @author lukew
 * @create 2024-02-19 10:33
 * 链表练习
 */
public class LinkedListAlgo {










    //打印链表
    public static void printAll(Node list){
        Node p = list;
        while(p != null){
            System.out.print(p.data + "   ");
            p = p.next;
        }
        System.out.println();
    }




    //创建结点
    public static Node createNode(int value){
        return new Node(value,null);
    }



    //结点类
    public static class Node{
        public int data;
        public Node next;

        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }





}
