package try_again.other_data_structure.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-12-23 13:28
 * 886.可能的二分图
 */
public class PossibleBipartition {

    private boolean ok = true;

    private boolean[] color;

    private boolean[] visited;

    public boolean possibaleBipartition(int n, int[][] dislikes){
        color = new boolean[n + 1];
        visited = new boolean[n + 1];

        //转换成邻接表表示图结构
        List<Integer>[] graph = buildGraph(n, dislikes);

        for(int v = 1; v <= n; v++){
            if(!visited[v]){
                traverse(graph, v);
            }
        }

        return ok;
    }


    /**
     * 建图函数
     */
    private List<Integer>[] buildGraph(int n, int[][] dislikes){

        List<Integer>[] graph = new LinkedList[n + 1];

        for(int i = 1; i <= n; i++){
            graph[i] = new LinkedList<>();
        }

        for(int[] edge : dislikes){
            int v = edge[1];
            int w = edge[0];
            graph[v].add(w);
            graph[w].add(v);
        }

        return graph;
    }


    /**
     * dfs
     */
    private void traverse(List<Integer>[] graph, int v){
        if(!ok){
            return ;
        }

        visited[v] = true;
        for(int w : graph[v]){
            if(!visited[w]){
                color[w] = !color[v];
                traverse(graph, w);
            }else{
                if(color[w] == color[v]){
                    ok = false;
                    return;
                }
            }
        }

    }
}
