package try_again.other_data_structure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-12-06 15:27
 * 加权有向图通用实现（邻接矩阵）
 */
public class WeightedDigraph2 {

    /**
     * 有向图的边（Edge）
     */
    public static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    /**
     * 邻接矩阵 matrix[from][to] 存储从节点from到节点to的边的权重
     * 默认0表示没有连接
     */
    private int[][] matrix;


    public WeightedDigraph2(int n){
        matrix = new int[n][n];
    }

    public void addEdge(int from, int to, int weight){
        matrix[from][to] = weight;
    }

    public void removeEdge(int from, int to){
        matrix[from][to] = 0;
    }

    public boolean hasEdge(int from, int to){
        return matrix[from][to] != 0;
    }

    public int weight(int from, int to){
        return matrix[from][to];
    }

    public List<Edge> neighbors(int v){
        List<Edge> res = new ArrayList<>();
        for(int i = 0; i < matrix[v].length; i++){
            if (matrix[v][i] > 0){
                res.add(new Edge(i, matrix[v][i]));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        WeightedDigraph2 graph = new WeightedDigraph2(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.hasEdge(0, 1));
        System.out.println(graph.hasEdge(1, 0));

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " -> " + edge.to + ", wight: " + edge.weight);
        });

        graph.removeEdge(0, 1);
        System.out.println(graph.hasEdge(0, 1));
    }


}
