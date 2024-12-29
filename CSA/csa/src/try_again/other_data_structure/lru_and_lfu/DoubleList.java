package try_again.other_data_structure.lru_and_lfu;

/**
 * @author lukew
 * @create 2024-09-18 14:24
 *
 * 双向链表实现
 */
public class DoubleList {

    private Node head, tail;

    private int size;

    public DoubleList(){
        //初始化双向链表的数据
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    //在链表尾部添加节点x 时间O(1)
    public void addLast(Node x){
        x.prev = tail.prev;
        x.next = tail;

        tail.prev.next = x;
        tail.prev = x;

        size++;
    }

    //删除链表中的x节点 O(1)
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    //删除链表中的第一个节点 并返回该节点 O(1)
    public Node removeFirst(){
        if (head.next == tail){
            return null;
        }

        Node first = head.next;
        remove(first);
        return first;
    }

    //返回长度
    public int size(){
        return size;
    }




}
