package try_again.array;

/**
 * @author lukew
 * @create 2024-04-25 9:41
 * 48.旋转图像
 */
public class Rotate {

    //逆时针旋转就是 沿对角线(左下到右上)对折
    //将二维矩阵原地顺时针旋转90度
    void rotate(int[][] matrix){

        int n = matrix.length;

        //1.沿对角线(左上到右下)镜像对称
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        //2.反转二维矩阵的每一行
        for(int[] row : matrix){
            reverse(row);
        }
    }

    //反转数组
    public void reverse(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }

    }
}
