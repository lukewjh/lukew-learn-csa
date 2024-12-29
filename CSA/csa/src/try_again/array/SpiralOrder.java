package try_again.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-04-25 10:09
 * 54.螺旋矩阵
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix){
        //给定四个边界 在遍历的同时分别对各个边界进行调整即可

        int m = matrix.length;
        int n = matrix[0].length;
        //上边界 下边界
        int upper_bound = 0, lower_bound = m - 1;
        //左边界 右边界
        int left_bound = 0, right_bound = n - 1;

        List<Integer> res = new ArrayList<>();

        while(res.size() < m * n){

            //遍历上边界的元素
            if (upper_bound <= lower_bound){
                for(int j = left_bound; j < right_bound; j++){
                    res.add(matrix[upper_bound][j]);
                }
                //上边界下移
                upper_bound++;
            }

            //遍历右边界（右侧从上到下）
            if (right_bound >= left_bound){
                for(int i = upper_bound; i < lower_bound; i++){
                    res.add(matrix[i][right_bound]);
                }
                //右边界左移
                right_bound--;
            }

            //底部 从右到左
            if (upper_bound <= lower_bound){
                for(int j = right_bound; j >= left_bound; j--){
                    res.add(matrix[lower_bound][j]);
                }
                lower_bound++;
            }

            //左边 从下到上
            if (left_bound <= right_bound){
                for (int i = lower_bound; i >= upper_bound; i--){
                    res.add(matrix[i][left_bound]);
                }

                left_bound++;
            }

        }

        return res;


    }
}
