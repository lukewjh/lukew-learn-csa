package dp;

import java.util.Arrays;

/**
 * @author lukew
 * @create 2024-03-25 14:18
 */
public class DP0 {


    public static void main(String[] args) {
        DP0 dp0 = new DP0();

        System.out.println(dp0.fib(10));

        System.out.println(dp0.F2(10));

        System.out.println(dp0.F3(10));
    }


    /**
     * 动态规划解法（节省空间）
     */
    public int F3(int n){
        if (n < 2) return n;
        int pre = 0,cur = 1;
        for (int i = 2;i <= n; i++){
            int temp = cur;
            cur = pre + cur;
            pre = temp;
        }
        return cur;
    }


    /**
     * 动态规划的解法(普通)
     */
    public int F2(int n){
        int[] dp = new int[n + 1];
        if (n > 0) dp[1] = 1;

        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }





    /**
     * 计算一个斐波那契数列的第n项(带备忘录的递归)
     * m是剪枝字典  记录已经计算过的值
     * @param n
     * @param m
     * @return
     */
    public int F(int n,int[] m){

        return m[n] != -1 ? m[n] : n < 2 ? m[n] = n : (m[n] =F(n-1,m) + F(n-2,m));

    }

    public int fib(int n){
        int[] m = new int[n + 1];
        Arrays.fill(m,-1);
        return F(n,m);

    }


}
