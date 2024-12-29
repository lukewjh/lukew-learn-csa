package try_again.array.sliderWindow;

/**
 * @author lukew
 * @create 2024-04-28 9:45
 *
 * 1004.最大连续1的个数III
 */
public class LongestOnes {

    public int longestOnes(int[] nums,int k){

        //滑动窗口
        int left = 0;
        int right = 0;

        //记录窗口内1的数量
        int windOneCount = 0;

        int res = 0;

        while(right < nums.length){

            if (nums[right] == 1){
                windOneCount++;
            }
            right++;

            //窗口内的0个数大于k则开始收缩窗口
            while(right - left - windOneCount > k){
                if (nums[left] == 1){
                    windOneCount--;
                }
                left++;

            }
            res = Math.max(res,right - left);

        }
        return res;

    }
}
