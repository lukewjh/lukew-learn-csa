package try_again.other_data_structure.priority_queue;

import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-10-17 11:15
 * 313.超级丑数
 */
public class NthSuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes){

        //优先级队列中装三元组int[]{product,prime,pi}
        //其中 product 代表链表节点的值，prime 是计算下一个节点所需的质数因子，pi 代表链表上的指针
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });


        //把多条链表头结点加入优先级队列
        for(int i = 0; i < primes.length; i++){
            pq.offer(new int[]{1, primes[i], 1});
        }

        //有序的结果链表
        int[] ugly = new int[n + 1];
        int p = 1;

        while(p <= n){
            //取出优先级队列中最小的节点
            int[] pair = pq.poll();
            int product = pair[0];
            int prime = pair[1];
            int index = pair[2];

            //避免结果链表重复
            if (product != ugly[p-1]){
                ugly[p] = product;
                p++;
            }

            //生成下一个节点加入优先级队列
            int[] nextPair = new int[]{ugly[index] * prime, prime, index + 1};
            pq.offer(nextPair);

        }
        return ugly[n];

    }
}
