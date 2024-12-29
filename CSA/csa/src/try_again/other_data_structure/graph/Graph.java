package try_again.other_data_structure.graph;



import java.util.List;

/**
 * @author lukew
 * @create 2024-12-06 15:00
 * 通用图结构接口
 */
public interface Graph {

    class Edge{
        int to;
        int weight;
    }

    /**
     * 添加一条边(带权重)
     */
    void addEdge(int from, int to, int weight);

    /**
     * 删除一条边
     */
    void removeEdge(int from, int to);

    /**
     * 判断两个节点是否相邻
     */
    boolean hasEdge(int from, int to);

    /**
     * 返回一条边的权重
     */
    int weight(int from, int to);

    /**
     * 返回某个节点的所有邻居节点和对应权重
     */
    List<Edge> neighbors(int v);

    /**
     * 返回总节点数
     */
    int size();

}
