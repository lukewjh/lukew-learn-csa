package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lukew
 * @create 2024-03-11 9:03
 * 图的实现
 */
public class GraphMain {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);

        //广度优先
        graph.bfs(1,5);

        System.out.println();
        //深度优先
        graph.dfs(1,5);


    }

    static class Graph{
        //定点个数
        private int v;
        //邻接表
        private LinkedList<Integer>[] adj;

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            //初始化邻接表
            for (int i = 0;i < v; i++){
                adj[i] = new LinkedList<>();
            }
        }

        //添加定点和对应关系的边
        public void addEdge(int s,int t){
            adj[s].add(t);
            adj[t].add(s);
        }

        //递归打印找到顶点的路径
        public void print(int[] prev,int s,int t){
            if (prev[t] != -1 && t != s){
                print(prev,s,prev[t]);
            }
            System.out.print(t + "  ");

        }

        //广度优先搜索（Breadth first Search）
        public void bfs(int s,int t){

            if ( s == t){
                return ;
            }

            //已访问的数组
            boolean[] visited = new boolean[v];
            visited[s] = true;

            //将要访问的队列
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);

            //初始化
            int[] prev = new int[v];
            for (int i = 0; i < prev.length; i++){
                prev[i] = -1;
            }

            while(queue.size() > 0){
                int w = queue.poll();
                for (int i = 0; i < adj[w].size(); i++){
                    int q = adj[w].get(i);
                    if (!visited[q]){
                        prev[q] = w;
                        if (q == t){
                            print(prev,s,t);
                            return;
                        }

                        visited[q] = true;
                        queue.add(q);
                    }

                }

            }


        }

        //深度优先搜索
        boolean found = false;
        public void dfs(int s,int t){
            found = false;
            boolean[] visited = new boolean[v];

            int[] prev = new int[v];
            for (int i = 0; i<v; i++){
                prev[i] = -1;
            }

            //递归
            recurDfs(s,t,visited,prev);
            print(prev,s,t);
        }

        public void recurDfs(int w, int t, boolean[] visited, int[] prev){
            if (found == true) return;
            visited[w] = true;
            if (w == t){
                found = true;
                return;
            }

            for (int i = 0; i < adj[w].size();i++){
                int q = adj[w].get(i);
                if (!visited[q]){
                    prev[q] = w;
                    recurDfs(q,t,visited,prev);
                }
            }
        }
    }
}
