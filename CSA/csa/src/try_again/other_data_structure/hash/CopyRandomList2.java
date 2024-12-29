package try_again.other_data_structure.hash;

import try_again.other_data_structure.hash.util.Node;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author lukew
 * @create 2024-09-24 10:12
 */
public class CopyRandomList2 {


    /**
     * 递归方案
     */
    public Node copyRandomList2(Node head){
        traverse(head);
        return originToClone.get(head);
    }

    //原节点到新节点的映射
    HashMap<Node,Node> originToClone = new HashMap<>();

    //记录DFS遍历过的节点 防止回头路
    HashSet<Node> visited = new HashSet<>();

    public void traverse(Node node){

        if (node == null){
            return;
        }

        if (visited.contains(node)){
            return;
        }

        //前序对节点初始化处理
        visited.add(node);
        if (originToClone.containsKey(node)){
            originToClone.put(node, new Node(node.val));
        }

        Node cloneNode = originToClone.get(node);


        //后序对节点结构完善
        traverse(node.next);
        cloneNode.next = originToClone.get(node.next);

        traverse(node.random);
        cloneNode.random = originToClone.get(node.random);


    }

}
