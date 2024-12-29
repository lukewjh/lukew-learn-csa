package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-05-06 16:02
 * 74.搜索二维矩阵
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix,int target){

        int m = matrix.length;
        int n = matrix[0].length;

        //二维数组的下标映射成一维
        int left = 0;
        int right = n * m - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if (get(matrix,mid) == target){
                return true;
            }else if (get(matrix, mid) < target){
                left = mid + 1;
            }else if (get(matrix,mid) > target){
                right = mid - 1;
            }

        }
        return false;

    }

    //通过一维坐标 获取二维矩阵中的元素
    public int get(int[][] matrix, int index){
        int m = matrix.length;
        int n = matrix[0].length;
        int i = index / n;
        int j = index % n;

        return matrix[i][j];

    }
}
