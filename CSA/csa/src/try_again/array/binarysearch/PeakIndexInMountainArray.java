package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-05-07 10:58
 * 852.山脉数组的峰顶索引
 */
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] nums){

        //与162解法一致
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]){
                //mid及其左侧可能是峰值 收缩右边界
                right = mid;
            }else{
                //mid右侧有一个峰值
                left = mid + 1;
            }

        }
        return left;

    }
}
