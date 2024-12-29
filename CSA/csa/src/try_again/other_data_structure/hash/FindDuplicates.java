package try_again.other_data_structure.hash;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-09-30 14:09
 * 442.数组中重复的元素
 */
public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums){

        int n = nums.length;
        List<Integer> res = new LinkedList<>();
        //用数组模拟hash集合
        int[] seen = new int[n + 1];
        for(int num : nums){
            if (seen[num] == 0){
                seen[num] = 1;
            }else{
                res.add(num);
            }
        }
        return res;

    }
}
