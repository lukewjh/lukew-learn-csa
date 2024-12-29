package try_again.other_data_structure.priority_queue;

import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-10-16 11:01
 * 378.有序矩阵中第k小的元素
 */
public class KthSmallest {

    public int KthSmallest(int[][] matrix, int k){

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
           return a[0] - b[0];
        });

        for(int i = 0; i < matrix.length; i++){
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        int res = -1;

        while(!pq.isEmpty() && k > 0){
            int[] cur = pq.poll();
            res = cur[0];
            k--;
            //链表中的下一个节点加入优先级队列
            int i = cur[1], j = cur[2];
            if (j + 1 < matrix[i].length){
                pq.add(new int[]{matrix[i][j + 1], i, j + 1});
            }

        }
        return res;

    }
}
