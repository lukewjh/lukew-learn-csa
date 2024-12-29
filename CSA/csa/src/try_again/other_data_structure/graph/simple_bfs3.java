package try_again.other_data_structure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lukew
 * @create 2024-12-13 9:45
 * bfs写法三 (可适配不同的权重)
 */

class State{
    int node;

    int weight;

    public State(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}

public class simple_bfs3 {

    void bfs(Graph graph, int s){
        boolean[] visited = new boolean[graph.size()];
        Queue<State> q = new LinkedList<>();

        q.offer(new State(s, 0));
        visited[s] = true;

        while(!q.isEmpty()){
            State state = q.poll();
            int cur = state.node;
            int weight = state.weight;

            for(Graph.Edge e : graph.neighbors(cur)){
                if (!visited[e.to]){
                    q.offer(new State(e.to, weight + e.weight));
                    visited[e.to] = true;
                }
            }
        }

    }

}

