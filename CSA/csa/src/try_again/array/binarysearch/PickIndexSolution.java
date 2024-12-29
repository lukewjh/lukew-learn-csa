package try_again.array.binarysearch;

import java.util.Random;

/**
 * @author lukew
 * @create 2024-05-09 9:27
 * 528.按权重随机选择
 */
public class PickIndexSolution {

    //前缀和
    int[] preSum;
    Random rand = new Random();

    public PickIndexSolution(int[] w){
        int n = w.length;

        //构建前缀和
        preSum = new int[n + 1];
        preSum[0] = 0;

        for (int i = 1; i <= n; i++){
            preSum[i] = preSum[i - 1] + w[i - 1];
        }

    }

    public int pickIndex(){
        int n = preSum.length;

        int target = rand.nextInt(preSum[n - 1]) + 1;

        return leftBound(preSum,target) - 1;
    }

    int leftBound(int[] nums, int target){

        if (nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length;
        while(left < right){

            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid;
            }

        }
        return left;

    }
}
