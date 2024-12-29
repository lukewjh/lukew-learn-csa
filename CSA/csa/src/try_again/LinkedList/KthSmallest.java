package try_again.LinkedList;

import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-04-03 14:00
 * 378.有序矩阵中第k小的元素
 */
public class KthSmallest {


    /**
     * 思路  使用优先级队列 合并多条有序链表的思想
     * @param matrix
     * @param k
     * @return
     */
    int kthSmallest(int[][] matrix,int k){
        //用来存储数组的内容为（matrix[i][j],i,j）  1.第i行第j列的值  2.第i行  3.第j列
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });


        //初始化优先级队列 把每一行的第一个元素放入
        for (int i = 0;i < matrix.length; i++){
            pq.offer(new int[]{matrix[i][0], i, 0});
        }

        int res = -1;
        while(!pq.isEmpty() && k > 0){
            int[] cur = pq.poll();
            res = cur[0];
            k--;

            //把该行的下一个元素放入最小堆
            int i = cur[1];
            int j = cur[0];
            if (j+1 < matrix[i].length){
                pq.add(new int[]{matrix[i][j+1],i,j+1});
            }
        }

        return res;


    }

}
