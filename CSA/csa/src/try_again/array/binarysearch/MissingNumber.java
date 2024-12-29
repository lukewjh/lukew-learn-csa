package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-05-08 10:02
 * LCR 173.点名（0~n-1 中缺失的数字）
 */
public class MissingNumber {

    public int missingNumber(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid){
                //mid 和 nums[mid] 不对应，说明左边有元素缺失
                right = mid - 1;
            }else{
                //mid 和 nums[mid] 对应  说明缺失的元素在右边
                left = mid + 1;
            }

        }
        return left;

    }
}
