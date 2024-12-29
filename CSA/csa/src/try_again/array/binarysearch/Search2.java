package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-05-08 16:51
 * 81.搜索旋转排序数组II
 */
public class Search2 {

    public boolean search2(int[] nums, int target){

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){

            //在计算mid之前把左右边界的重复元素跳过
            while(left < right && nums[left] == nums[left + 1]){
                left++;
            }

            while(left < right && nums[right] == nums[right - 1]){
                right--;
            }

            //然后就和33的逻辑一致  查找不存在重复值的旋转数组
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return true;
            }

            if (nums[mid] >= nums[left]){

                if (target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }

            }else{

                if (target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }



        }

        return false;

    }
}
