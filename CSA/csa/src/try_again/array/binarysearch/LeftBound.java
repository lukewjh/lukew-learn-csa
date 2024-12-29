package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-04-11 10:41
 * 二分搜索的左侧边界
 */
public class LeftBound {


    public int leftBoud (int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (right - left)/2 + left;

            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                right = mid - 1;
            }
        }

        if (left < 0 || left > nums.length){
            return -1;
        }
        return nums[left] == target? left : -1;
    }
}
