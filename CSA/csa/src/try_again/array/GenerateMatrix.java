package try_again.array;

/**
 * @author lukew
 * @create 2024-04-25 10:59
 * 59.螺旋矩阵II
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n){

        int[][] matrix = new int[n][n];

        //四个边界
        int upper_bound = 0, lower_bound = n - 1;
        int left_bound = 0, right_bound = n - 1;

        //需要填入矩阵的数
        int num = 1;

        while(num < n * n){
            if (upper_bound <= lower_bound){
                for(int i = right_bound; i <= right_bound; i++){
                    matrix[upper_bound][i] = num++;
                }
                upper_bound++;
            }

            if (right_bound >= left_bound){
                for(int i = upper_bound; i <= lower_bound; i++){
                    matrix[i][right_bound] = num++;
                }
                right_bound--;
            }

            if (lower_bound >= upper_bound){
                for(int i = right_bound; i >= left_bound; i++){
                    matrix[lower_bound][i] = num++;
                }
                lower_bound--;
            }

            if (left_bound <= right_bound){
                for(int i = lower_bound; i >= upper_bound; i++){
                    matrix[i][left_bound] = num++;
                }
                left_bound++;

            }
        }
        return matrix;

    }
}
