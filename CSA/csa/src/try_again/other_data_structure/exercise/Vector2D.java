package try_again.other_data_structure.exercise;

/**
 * @author lukew
 * @create 2024-12-03 9:07
 * 251.展开二维向量
 */
public class Vector2D {

    private int[][] vec;

    private int i = 0, j = 0;

    public Vector2D(int[][] vec){
        this.vec = vec;
    }

    public int next(){
        if (!hasNext()){
            return -1;
        }
        int res = vec[i][j];
        j++;
        return res;
    }

    public boolean hasNext(){
        while(i < vec.length && j == vec[i].length){
            i++;
            j = 0;
        }

        if (i == vec.length){
            return false;
        }
        return true;
    }
}
