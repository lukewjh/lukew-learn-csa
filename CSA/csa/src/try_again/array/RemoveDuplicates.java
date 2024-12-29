package try_again.array;

/**
 * @author lukew
 * @create 2024-04-09 9:17
 * 26.移除升序数组中重复的元素
 */
public class RemoveDuplicates {


    public int removeDuplicates(int[] nums){
        //使用快慢指针
        if (nums.length == 0){
            return 0;
        }

        int fast = 0;
        int slow = 0;

        while(fast < nums.length){
            if (nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }
}
