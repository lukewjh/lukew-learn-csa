package try_again.array;

/**
 * @author lukew
 * @create 2024-04-09 9:49
 * 27.删除数组中指定的所有相等的元素
 */
public class RemoveElement {

    public int removeElement(int[] nums,int val){

        int fast = 0;
        int slow = 0;
        while(fast < nums.length){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;

    }

}
