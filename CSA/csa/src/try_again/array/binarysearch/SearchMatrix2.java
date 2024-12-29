package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-05-06 16:29
 * 240.搜索二维矩阵II
 */
public class SearchMatrix2 {

    //定义下标从矩阵的右上角(第一行 最后一列)开始搜索 往左是减少 往下是增加
    public boolean searchMatrix2(int[][] matrix, int target){

        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n - 1;

        while(i < m && j >= 0){
            if (matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] < target){
                //小于目标值 行数往下移动
                i++;
            }else{
                j--;
            }
        }
        return false;


    }
}
