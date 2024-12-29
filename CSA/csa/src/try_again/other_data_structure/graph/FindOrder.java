package try_again.other_data_structure.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-12-16 13:51
 * 210.课程表II
 */
public class FindOrder {

    List<Integer> postorder = new ArrayList<>();

    boolean hasCycle = false;
    boolean[] visited, onPath;

    int[] findOrder(int numCourses, int[][] prerequisites){

        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        //遍历图
        for(int i = 0; i < numCourses; i++){
            traverse(graph, i);
        }

        //有环图无法进行拓扑排序
        if (hasCycle){
            return new int[]{};
        }

        //逆后序遍历结果
        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            res[i] = postorder.get(i);
        }
        return res;

    }

    /**
     * 图遍历函数 dfs
     */
    void traverse(List<Integer>[] graph, int s){
        if(onPath[s]){
            hasCycle = true;
        }

        if(visited[s] || hasCycle){
            return;
        }

        onPath[s] = true;
        visited[s] = true;

        for(int t : graph[s]){
            traverse(graph, t);
        }

        //后序遍历位置 进行拓扑排序
        postorder.add(s);
        onPath[s] = false;
    }


    /**
     * 建图函数
     */
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
