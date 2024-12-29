package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-05-08 11:06
 * 33.搜索旋转排序数组
 */
public class Search {

    public int search(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            //检查nums[mid]  是否找到target
            if (nums[mid] == target){
                return mid;
            }

            //判断mid当前落在左边还是右边
            if (nums[mid] >= nums[left]){

                //此时落在断崖的左边 [left...mid - 1]有序
                if (target >= nums[left] && target < nums[mid]){
                    //target落在[left..mid - 1]
                    right = mid - 1;
                }else{
                    //target落在[mid + 1..right]
                    left = mid + 1;
                }

            }else{
                //落在断崖的右边[mid..right] 有序
                if (target <= nums[right] && target > nums[mid]){
                    // 落在 [mid+1..right]
                    left = mid + 1;
                }else{
                    // 落在 [left..mid-1]
                    right = mid - 1;
                }

            }

        }

        return -1;

    }
}
