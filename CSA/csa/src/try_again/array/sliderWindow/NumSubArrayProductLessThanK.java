package try_again.array.sliderWindow;

/**
 * @author lukew
 * @create 2024-04-28 9:19
 * 713.乘积小于k的子数组
 */
public class NumSubArrayProductLessThanK {


    public int numSubArrayproductLessThanK(int[] nums,int k){

        //滑动窗口
        int left = 0;
        int right = 0;

        int windowProduct = 1;

        //记录符合条件的
        int count = 0;

        while(right < nums.length){
            //扩大窗口并更新
            windowProduct = windowProduct * nums[right];
            right++;

            //当乘积大于k时就缩小窗口
            while(left < right && windowProduct >= k){
                windowProduct = windowProduct / nums[left];
                left++;
            }

            //到达此处证明该窗口是合法的 子数组
            //count 等于窗口中的所有子数组
            count += right - left;
        }

        return count;

    }
}
