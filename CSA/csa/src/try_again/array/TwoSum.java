package try_again.array;

/**
 * @author lukew
 * @create 2024-04-12 9:24
 * 167.两数之和 （升序数组）
 */
public class TwoSum {

    public int[] twoSum(int[] nums,int target){

        //左右指针
        int left = 0,right = nums.length - 1;
        while(left < right){
            int sum = nums[left] + nums[right];
            if (sum == target){
                return new int[]{left + 1, right + 1};
            }else if (sum < target){
                left++;
            }else if (sum > target){
                right--;
            }
        }


        return new int[]{-1,-1};

    }
}
