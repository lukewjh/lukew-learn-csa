package try_again.array;

/**
 * @author lukew
 * @create 2024-07-18 9:01
 * kadane算法
 */
public class Kadane {

    //求子数组的最大和
    public static int maxSubArraySum(int[] arr){
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for(int i = 1; i < arr.length; i++){
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar,maxEndingHere);
        }

        return maxSoFar;
    }
}
