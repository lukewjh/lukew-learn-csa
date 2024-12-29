package try_again.other_data_structure.lru_and_lfu;

/**
 * @author lukew
 * @create 2024-09-18 14:22
 * 哈希链表的节点类
 */
public class Node {

    public int key, val;

    public Node next, prev;

    public Node(int k, int val){
        this.key = k;
        this.val = val;
    }

}
