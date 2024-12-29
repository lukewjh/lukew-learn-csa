package try_again.LinkedList.ugly;

/**
 * @author lukew
 * @create 2024-04-03 11:00
 * 给定一个整数n，返回第n个丑数
 * 丑数：包含质因数2、3、5的正整数
 * 使用合并链表的思想来解决 以及 素数的筛选法的思想
 */
public class NthUglyNumber {


    public static void main(String[] args) {
        NthUglyNumber nun = new NthUglyNumber();
        System.out.println(nun.nthUglyNumber(10));
    }

    int nthUglyNumber(int n){

        //三个指向有序链表的指针
        int p2 = 1,p3 = 1,p5 = 1;
        //三个有序链表的头结点的值
        int product2 = 1,product3 = 1,product5 = 1;

        //理解为最终合并的有序链表（结果链表）
        int[] ugly = new int[n+1];
        //在结果链表上的指针
        int p = 1;

        //合并三个有序链表
        while(p <= n){

            //取得三个链表中的最小值
            int min = Math.min(Math.min(product2, product3), product5);

            //将最小值接入结果链表中
            ugly[p] = min;

            //结果链表前进
            p++;

            //前进对应有序链表的指针
            if (min == product2){
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (min == product3){
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (min == product5){
                product5 = 5 * ugly[p5];
                p5++;
            }

        }
        //返回第n个就是已经合并了的
        return ugly[n];

    }
}
