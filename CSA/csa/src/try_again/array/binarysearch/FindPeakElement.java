package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-05-07 10:34
 * 162.寻找峰值
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums){
        //用二分搜索对比mid 和 mid+1
        //nums[mid] > nums[mid + 1] 得到 mid是峰值 或者 mid的左侧是峰值  这里就收缩 right = mid
        //nums[mid + 1] < nums[mid] 得到 mid的右侧就是一个峰值 left = mid + 1

        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]){
                //mid本身是一个峰值 或者左侧有峰值
                right = mid;
            }else{
                //mid右侧有一个峰值
                left = mid + 1;
            }

        }
        return left;
    }
}
