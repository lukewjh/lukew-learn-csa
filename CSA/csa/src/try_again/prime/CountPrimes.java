package try_again.prime;

import java.util.Arrays;

/**
 * @author lukew
 * @create 2024-04-02 10:49
 * 使用筛选法获得(2，n]的素数
 */
public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(10));
    }



    public int countPrimes(int n){
        //创建一个数组用来记录哪些事素数哪些不是
        boolean[] isPrime = new boolean[n];
        //初始化填充都为true
        Arrays.fill(isPrime,true);

        //素数就是找到是否有除了自己和1之外的因子数
        //i*i是解决了不需要找到重复因子的一种方法  sqrt(i*i) < sqrt(n) 就只要找一半了
        for (int i = 2;i * i < n; i++){
            if (isPrime[i]){
                //排除所有找到该素数的所有其他倍数值
                for (int j = i*i;j < n; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for(int i = 2;i < n; i++){
            if (isPrime[i]) count++;
        }

        return count;
    }

}
