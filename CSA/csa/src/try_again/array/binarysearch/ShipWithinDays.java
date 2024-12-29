package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-05-06 10:13
 * 1011.在D天内送达包裹的能力
 */
public class ShipWithinDays {

    //当运载能力为x时，需要f(x)天运完所有货物
    public int f(int[] weights, int x){
        int days = 0;
        for (int i = 0; i < weights.length;){

            int cap = x;
            while(i < weights.length){

                if (cap < weights[i]){
                    break;
                }else{
                    cap -= weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }


    public int shipWithinDays(int[] weights, int days){
        int left = 0;
        int right = 1;

        //初始化最小和最大运载量  最小就是所要运载货物的最大元素  最大就是所要运载货物的总和
        for (int w : weights){
            left = Math.max(left, w);
            right += w;
        }

        while(left < right){

            int mid = left + (right - left) / 2;
            if (f(weights,mid) == days){
                right = mid;
            }else if (f(weights,mid) < days){
                right = mid;
            }else if (f(weights,mid) > days){
                left = mid + 1;
            }

        }

        return left;

    }
}
