package try_again.other_data_structure.hash;

import java.util.HashSet;

/**
 * @author lukew
 * @create 2024-09-20 10:36
 * 128.最长连续序列
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums){

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int res = 0;

        for(int num : set){

            if (set.contains(num - 1)){
                //该元素还存在上一个元素  所以不是连续子序列的第一个 跳过
                continue;
            }

            int curNum = num;
            int curLen = 1;

            while(set.contains(curNum + 1)){
                curNum += 1;
                curLen += 1;
            }

            res = Math.max(res,curLen);

        }
        return res;

    }
}
