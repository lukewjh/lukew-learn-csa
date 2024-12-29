package try_again.other_data_structure.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lukew
 * @create 2024-12-17 9:46
 * 是否成环 BFS版
 */
public class CanFinish2 {


    public boolean canFinish(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            int from = edge[1], to = edge[0];
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            for(int next : graph[cur]){
                indegree[next]--;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        //如果所有的节点都被bfs遍历过 则代表不成环
        return count == numCourses;

    }




    /**
     * 构建图
     */
    List<Integer>[] buildGraph(int n, int[][] edges){
        List<Integer>[] graph = new LinkedList[n];
        //构建节点
        for(int i = 0; i < n; i++){
            graph[i] = new LinkedList<>();
        }

        //构建边
        for(int[] edge : edges){
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }

        return graph;

    }
}
