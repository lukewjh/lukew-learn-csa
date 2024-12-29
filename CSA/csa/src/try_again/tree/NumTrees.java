package try_again.tree;

/**
 * @author lukew
 * @create 2024-05-30 14:19
 * 96.不同的二叉搜索树
 */
public class NumTrees {

    //加上备忘录 去除重叠子问题
    int[][] memo;

    public int numTrees(int n){
        memo = new int[n + 1][n + 1];

        //计算闭区间[1,n]组成的BST个数
        return count(1, n);
    }

    //计算闭区间[lo,hi]组成的BST个数
    public int count(int lo, int hi){

        if (lo > hi){
            return 1;
        }

        //看备忘录是否已经计算过了
        if (memo[lo][hi] != 0){
            return memo[lo][hi];
        }

        int res = 0;

        for (int i = lo; i <= hi; i++){
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);

            //左右子树的组合乘积是BST的组成
            res += left * right;
        }

        //存入备忘录
        memo[lo][hi] = res;

        return res;

    }
}
