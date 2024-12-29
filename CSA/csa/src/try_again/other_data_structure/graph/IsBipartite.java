package try_again.other_data_structure.graph;

/**
 * @author lukew
 * @create 2024-12-20 11:21
 * 785.判断二分图
 */
public class IsBipartite {


    private boolean ok =true;

    private boolean[] color;

    private boolean[] visited;

    public boolean isBipartite(int[][] graph){

        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];

        for(int v = 0; v < n; v++){
            if(!visited[v]){
                traverse(graph, v);
            }
        }

        return ok;

    }

    private void traverse(int[][] graph, int v){
        if(!ok){
            return ;
        }

        visited[v] = true;

        for(int w : graph[v]){
            if(!visited[w]){
                color[w] = !color[v];
                traverse(graph, v);
            }else{
                if(color[w] == color[v]){
                    ok = false;
                    return;
                }
            }
        }

    }

}
