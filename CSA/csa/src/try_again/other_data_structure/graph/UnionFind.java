package try_again.other_data_structure.graph;

/**
 * @author lukew
 * @create 2024-12-24 11:30
 * 并查集算法
 */
public class UnionFind {
    //连通分量个数
    private int count;

    //存储每个节点的父节点
    private int[] parent;

    //初始化
    public UnionFind(int n){
        this.count = n;
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i ;
        }
    }

    public void unoin(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ){
            return;
        }

        parent[rootQ] = rootP;
        count--;

    }

    public boolean connected(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    public int find(int x){
        if(parent[x] != x){
            //使用递归进行路径压缩
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public int count(){
        return count;
    }
}
