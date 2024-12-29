package try_again.other_data_structure.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-12-16 10:16
 * 207.课程表
 */
public class CanFinish {

    boolean[] onPath;

    boolean hasCycle = false;

    //记录节点是否已遍历
    boolean[] visited;

    boolean canFinish(int numCourses, int[][] prerequisites){

        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            traverse(graph, i);
        }
        return !hasCycle;

    }

    void traverse(List<Integer>[] graph, int s){
        if(hasCycle){
            return ;
        }

        if(onPath[s]){
            hasCycle = true;
            return;
        }

        if(visited[s]){
            return;
        }

        visited[s] = true;
        onPath[s] = true;

        for(int t : graph[s]){
            traverse(graph, t);
        }

        onPath[s] = false;

    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new LinkedList<>();
        }

        for(int[] edge : prerequisites){
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }

        return graph;
    }
}
