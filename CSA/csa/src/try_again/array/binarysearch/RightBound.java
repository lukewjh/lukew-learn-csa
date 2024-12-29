package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-04-11 13:07
 * 二分搜索的右侧边界
 */
public class RightBound {

    public int rightBound(int[] nums,int target){

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (right - left)/2 + left;

            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                left = mid + 1;
            }
        }

        if (left - 1 < 0 || left - 1 >= nums.length){
            return -1;
        }

        return nums[left - 1] == target ? (left - 1):-1;

    }
}
