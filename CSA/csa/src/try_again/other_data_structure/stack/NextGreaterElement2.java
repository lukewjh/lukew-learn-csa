package try_again.other_data_structure.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author lukew
 * @create 2024-07-08 14:27
 *
 * 496.下一个更大的元素I
 */
public class NextGreaterElement2 {

    int[] nextGreaterElement2(int[] nums1, int[] nums2){

        int[] greater = nextGreaterElement(nums2);

        HashMap<Integer,Integer> greaterMap = new HashMap<>();

        for(int i = 0; i < nums2.length; i++){
            greaterMap.put(nums2[i], greater[i]);
        }

        //nums1是nums2的子集所以根据greaterMap可以得到结果
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = greaterMap.get(nums1[i]);
        }

        return res;
    }

    //因为nums1是nums2的子集  所以先将nums2每个元素的下一个最大元素获取到 并存入映射 方便找
    int[] nextGreaterElement(int[] nums){
        int n = nums.length;

        int[] res = new int[n];

        Stack<Integer> stk = new Stack<>();

        for(int i = n - 1; i >= 0; i--){

            while(!stk.isEmpty() && stk.peek() <= nums[i]){
                stk.pop();
            }

            res[i] = stk.isEmpty() ? -1 : stk.peek();

            stk.push(nums[i]);

        }

        return res;

    }


}
