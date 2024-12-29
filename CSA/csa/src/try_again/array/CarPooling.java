package try_again.array;

/**
 * @author lukew
 * @create 2024-04-23 13:46
 * 1094.拼车
 */
public class CarPooling {

    boolean carPooling(int[][] trips, int capacity){

        //0 <= trips[i][1] < trips[i][2] <= 1000
        int[] nums = new int[1001];

        //差分数组
        int[] diff = new int[nums.length];

        for(int[] trip : trips){
            //乘客数量
            int val = trip[0];

            //第trip[1] 站上车乘客
            int i = trip[1];
            //第trip[2] 站上车乘客
            int j = trip[2];

            diff[i] += val;
            if (j < diff.length){
                diff[j + 1] = val;
            }
        }

        //原数组
        int[] res = new int[diff.length];
        res[0] = diff[0];

        for(int i = 1; i < diff.length; i++){
            res[i] = res[i - 1] + diff[i];
        }

        //判断是否超过载
        for (int i = 0; i < res.length; i++){
            if (res[i] > capacity){
                return false;
            }
        }

        return true;
    }
}
