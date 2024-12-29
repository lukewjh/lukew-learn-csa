package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-04-11 9:56
 * 二分搜索
 */
public class BinarySearch {

    public int binarySearch(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (right - left)/2 + left;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;

    }

}
