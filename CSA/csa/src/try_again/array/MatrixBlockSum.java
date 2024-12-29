package try_again.array;

/**
 * @author lukew
 * @create 2024-04-17 9:01
 * 1314.矩阵区域和
 */
public class MatrixBlockSum {

    /**
     * 返回一个矩阵 其中的每个元素 满足以下
     * 1.i - k <= r <= i + k
     * 2.j - k <= c <= j + k
     * 3.(r, c) 在矩阵内
     */

    public int[][] matrixBlockSum(int[][] mat,int k){

        int m = mat.length;
        int n = mat[0].length;

        NumMatrix numMatrix = new NumMatrix(mat);
        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                //获取满足条件的坐标
                int x1 = Math.max(i - k,0);
                int y1 = Math.max(j - k,0);

                int x2 = Math.min(i + k,m - 1);
                int y2 = Math.min(j + k,n - 1);

                res[i][j] = numMatrix.sumRegion(x1,y1,x2,y2);

            }
        }
        return res;
    }

    class NumMatrix{

        int[][] preSum;

        public NumMatrix(int[][] matrix){

            int m = matrix.length;
            int n = matrix[0].length;

            //前缀和矩阵初始化
            preSum = new int[m][n];
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] + preSum[i - 1][j - 1];
                }
            }

        }

        public int sumRegion(int x1,int y1,int x2,int y2){
            return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
        }
    }
}


