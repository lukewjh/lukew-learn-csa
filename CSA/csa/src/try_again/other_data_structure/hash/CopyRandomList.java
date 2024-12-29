package try_again.other_data_structure.hash;

import try_again.other_data_structure.hash.util.Node;

import java.util.HashMap;

/**
 * @author lukew
 * @create 2024-09-24 9:20
 * 138.随机链表的复制
 */
public class CopyRandomList {




    /**
     * 遍历方案
     * @param head
     * @return
     */
    public Node copyRandomList(Node head){

        //使用Hash表进行节点遍历暂存  再深度结构连接
        HashMap<Node,Node> originToClone = new HashMap<>();

        for(Node p = head; p != null; p = p.next){
            if (!originToClone.containsKey(p)){
                originToClone.put(p, new Node(p.val));
            }
        }

        for(Node p = head; p != null; p = p.next){
            if (p.next != null) {
                originToClone.get(p).next = originToClone.get(p.next);
            }

            if (p.random != null) {
                originToClone.get(p).random = originToClone.get(p.random);
            }
        }

        //返回克隆之后的头节点
        return originToClone.get(head);

    }
}
