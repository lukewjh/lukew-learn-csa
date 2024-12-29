package try_again.other_data_structure.priority_queue;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-10-25 9:31
 * 1834.单线程CPU
 */
public class GetOrder {

    public int[] getOrder(int[][] tasks){
        int n = tasks.length;

        ArrayList<int[]> triples = new ArrayList<>();

        for(int i = 0; i < tasks.length; i++){

            triples.add(new int[]{tasks[i][0], tasks[i][1], i});
        }

        triples.sort((a,b) -> {
            return a[0] - b[0];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[1] != b[1]){
                return a[1] - b[1];
            }
            return a[2] - b[2];
        });

        ArrayList<Integer> res = new ArrayList<>();
        int now = 0;
        int i = 0;

        while(res.size() < n){
            if(!pq.isEmpty()){
                int[] triple = pq.poll();
                res.add(triple[2]);
                now += triple[1];
            }else if (i < n && triples.get(i)[0] > now){
                now = triples.get(i)[0];
            }


            for(;i < n && triples.get(i)[0] <= now; i++){
                pq.offer(triples.get(i));
            }
        }

        int[] arr = new int[n];
        for(int j = 0; j < n; j++){
            arr[j] = res.get(j);
        }

        return arr;
    }
}
