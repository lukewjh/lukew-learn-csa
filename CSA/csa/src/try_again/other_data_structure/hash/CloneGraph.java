package try_again.other_data_structure.hash;

import try_again.other_data_structure.hash.util.GraphNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author lukew
 * @create 2024-09-26 10:09
 * 133.克隆图
 */
public class CloneGraph {

    public GraphNode cloneGraph(GraphNode node){

        traverse(node);
        return originToClone.get(node);
    }

    HashSet<GraphNode> visited = new HashSet<>();
    HashMap<GraphNode,GraphNode> originToClone = new HashMap<>();

    //dfs图遍历框架
    void traverse(GraphNode node){
        if (node == null) {
            return;
        }

        if (visited.contains(node)){
            return;
        }

        //前序位置标记为已访问
        visited.add(node);
        //前序位置克隆节点
        if (!originToClone.containsKey(node)){
            originToClone.put(node, new GraphNode(node.val));
        }

        GraphNode cloneNode = originToClone.get(node);

        //递归遍历邻居节点 构建克隆图
        for(GraphNode neighbor : node.neighbors){
            traverse(neighbor);
            GraphNode cloneNeighbor = originToClone.get(neighbor);
            cloneNode.neighbors.add(cloneNeighbor);
        }
    }
}
