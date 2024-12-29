package try_again.other_data_structure.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-12-09 15:07
 * 797.所有可能的路径
 */
public class simple_dfs {

    /**
     * 记录所有路径
     */
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        traverse(graph, 0);
        return res;
    }

    void traverse(int[][] graph, int s){

        path.addLast(s);

        int n = graph.length;

        if (s == n - 1){
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }

        for(int v : graph[s]){
            traverse(graph, v);
        }

        path.removeLast();
    }

}
