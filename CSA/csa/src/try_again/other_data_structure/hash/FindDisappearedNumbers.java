package try_again.other_data_structure.hash;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-09-30 14:24
 * 488.找到所有数组中消失的数字
 */
public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums){
        int n = nums.length;
        int[] count = new int[n + 1];

        for(int num : nums){
            count[num]++;
        }

        List<Integer> res = new LinkedList<>();
        for(int num = 1; num <= n; num++){
            if(count[num] == 0){
                res.add(num);
            }
        }

        return res;
    }
}
