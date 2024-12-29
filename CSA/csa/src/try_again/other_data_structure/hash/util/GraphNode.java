package try_again.other_data_structure.hash.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-09-26 10:09
 * 图节点
 */
public class GraphNode {

    public int val;

    public List<GraphNode> neighbors;

    public GraphNode(){
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }

    public GraphNode(int val) {
        this.val = val;
    }

    public GraphNode(int val, List<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}
