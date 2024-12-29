package try_again.array;

/**
 * @author lukew
 * @create 2024-04-23 13:12
 * 1109.航班预订统计
 */
public class CorpFlightBookings {

    int[] corpFlightBookings(int[][] bookings, int n){
        //差分数组
        int[] diff = new int[n];

        for (int[] booking : bookings){
            int i = booking[0];
            int j = booking[1];

            int inc = booking[2];

            diff[i - 1] += inc;

            if (j < diff.length){
                diff[j] -= inc;
            }

        }

        int[] res = new int[n];
        res[0] = diff[0];
        for(int i = 1; i < diff.length; i++){
            res[i] = res[i - 1] + diff[i];
        }

        return res;
    }
}
