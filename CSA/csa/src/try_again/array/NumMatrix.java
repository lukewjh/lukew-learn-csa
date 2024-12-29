package try_again.array;

/**
 * @author lukew
 * @create 2024-04-16 14:18
 * 304.二维区域和检索-矩阵不可变
 */
public class NumMatrix {


    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 0 || n == 0){
            return ;
        }

        //前缀和矩阵构造
        preSum = new int[m + 1][n + 1];

        for(int i = 1;i <= m; i++){
            for(int j = 1;j <= n; j++){
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i-1][j-1] - preSum[i-1][j-1];
            }
        }

    }

    public int sumRegion(int x1, int y1,int x2,int y2){

        return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
    }
}
