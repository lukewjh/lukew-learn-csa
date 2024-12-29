package try_again.array;

/**
 * @author lukew
 * @create 2024-04-23 9:49
 * 370.区间加法
 */
public class GetModifiedArray {

    public int[] getModifiedArray(int length, int[][] updates){

        //使用差分数组快速解决
        int[] diff = new int[length];
        for(int[] updateArr : updates){
            int i = updateArr[0];
            int j = updateArr[1];

            int inc = updateArr[2];

            //在区间增加
            diff[i] += inc;
            if (j + 1 < length){
                diff[j + 1] -= inc;
            }

        }

        int[] res = new int[length];
        res[0] = diff[0];
        for(int i = 1; i < diff.length; i++){
            res[i] = res[i - 1] + diff[i];

        }

        return res;

    }
}
