package try_again.array;

/**
 * @author lukew
 * @create 2024-04-12 11:30
 * 977.有序数组的平方
 */
public class SortedSquares {

    public int[] sortedSquares(int[] nums){
        int n = nums.length;

        //双指针 从前往后和从后往前
        int i = 0;
        int j = n - 1;

        int[] res = new int[n];
        int p = n - 1;

        while(i <= j){
            if (Math.abs(nums[i]) > Math.abs(nums[j])){
                res[p] = nums[i] * nums[i];
                i++;
            }else{
                res[p] = nums[j] * nums[j];
                j--;
            }
            p--;
        }
        return res;

    }
}
