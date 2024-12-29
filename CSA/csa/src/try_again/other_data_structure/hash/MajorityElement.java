package try_again.other_data_structure.hash;

/**
 * @author lukew
 * @create 2024-09-29 15:38
 * 169.多数元素
 */
public class MajorityElement {

    public int majorityElement(int[] nums){

        int target = 0;

        int count = 0;

        for(int i = 0; i < nums.length; i++){

            if (count == 0){
                //当计数器为0时 假设nums[i]就是众数
                target = nums[i];
                count = 1;
            }else if (nums[i] == target){
                count++;
            }else{
                count--;
            }

        }

        return target;

    }
}
