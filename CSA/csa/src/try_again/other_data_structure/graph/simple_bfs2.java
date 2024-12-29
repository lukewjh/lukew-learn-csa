package try_again.other_data_structure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lukew
 * @create 2024-12-12 11:34
 * bfs写法二 (记录遍历步数)
 */
public class simple_bfs2 {

    void bfs(Graph graph, int s){

        boolean[] visited = new boolean[graph.size()];

        Queue<Integer> q = new LinkedList<>();

        q.offer(s);
        visited[s] = true;

        int step = 0;

        while(!q.isEmpty()){
            int sz = q.size();

            for(int i = 0; i < sz; i++){
                int cur = q.poll();

                for(Graph.Edge e : graph.neighbors(cur)){
                    if(!visited[e.to]){
                        q.offer(e.to);
                        visited[e.to] = true;
                    }
                }
            }
        }
        step++;

    }
}
