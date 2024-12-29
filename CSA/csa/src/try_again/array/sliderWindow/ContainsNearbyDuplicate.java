package try_again.array.sliderWindow;

import java.util.HashSet;

/**
 * @author lukew
 * @create 2024-04-28 16:44
 * 219.存在重复元素II
 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k){

        //当窗口小于k时 扩大窗口
        //当窗口大于k时 缩小窗口
        //当窗口等于k时 且存在重复元素时返回true
        int left = 0, right = 0;

        HashSet<Integer> window = new HashSet<>();
        while(right < nums.length){

            //如果在窗口中已经记录了这个元素 即找到了重复元素 而且这个窗口的大小小于k
            if (window.contains(nums[right])){
                return true;
            }

            //扩大窗口 更新window
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
