package try_again.other_data_structure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lukew
 * @create 2024-12-12 11:22
 * bfs写法一 (不记录遍历步数)
 */
public class simple_bfs {



    /**
     * 图结构的BFS遍历 从s节点开始BFS
     * 说明：类似于树结构的层序遍历，树的层序遍历利用了队列
     */
    void bfs(Graph graph, int s){

        boolean[] visited = new boolean[graph.size()];

        Queue<Integer> q = new LinkedList<>();

        q.offer(s);

        visited[s] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(Graph.Edge e : graph.neighbors(cur)){
                if (!visited[e.to]){
                    q.offer(e.to);
                    visited[e.to] = true;
                }
            }

        }

    }



}
