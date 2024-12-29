package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-05-06 9:19
 * 875.爱吃香蕉的珂珂
 */
public class MinEatingSpeed {

    public long f(int[] piles, int x){
        //速度为x时吃完香蕉需要多久
        long hours = 0L;
        for(int i = 0; i < piles.length; i++){
            hours += piles[i] / x;
            if (piles[i] > 0){
                hours++;
            }

        }

        return hours;
    }


    public int minEatingSpeed(int[] piles, int h){

        //使用二分搜索查找最合适的小时数
        int left = 1;
        int right = 1000000000 + 1;

        while(left < right){

            int mid = left + (right - left) / 2;

            if (f(piles,mid) == h){
                right = mid;
            } else if (f(piles,mid) < h){
                right = mid;
            }else if (f(piles,mid) > h){
                left = mid - 1;

            }

        }

        return left;

    }
}
