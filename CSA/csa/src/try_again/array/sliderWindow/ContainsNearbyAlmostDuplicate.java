package try_again.array.sliderWindow;

import java.util.TreeSet;

/**
 * @author lukew
 * @create 2024-04-28 17:02
 * 220.存在重复元素III
 */
public class ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        //使用TreeSet来存储窗口内的数据
        //并用TreeSet 来获取窗口内中略大或略小的数 看这个差值是否小于t 如果这个值都不小于t的话就证明其他的值一定不小于t

        TreeSet<Integer> window = new TreeSet<>();

        //滑动窗口
        int left = 0, right = 0;

        while(right < nums.length){

            //找出略大于当前数的元素
            Integer ceiling = window.ceiling(nums[right]);
            if (ceiling != null && (long)ceiling - nums[right] <= t){
                return true;
            }

            //找出略小于当前数的元素
            Integer floor = window.floor(nums[right]);
            if (floor != null && (long) nums[right] - floor <= t){
                return true;
            }

            //扩大窗口
            window.add(nums[right]);
            right++;

            //缩小窗口
            if (right - left > k){
                window.remove(nums[left]);
                left++;
            }
        }

        return false;
    }
}
