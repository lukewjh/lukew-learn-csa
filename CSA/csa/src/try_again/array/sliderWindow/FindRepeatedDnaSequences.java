package try_again.array.sliderWindow;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-04-29 14:05
 * 187.重复的DNA序列
 */
public class FindRepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s){

        //将字符串转为四进制数字数组
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++){
            switch(s.charAt(i)){
                case 'A':
                    nums[i] = 0;
                    break;
                case 'G':
                    nums[i] = 1;
                    break;
                case 'C':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }

        //记录重复出现的哈希值
        HashSet<Integer> seen = new HashSet<>();
        //记录重复出现的字符串结果
        HashSet<String> res = new HashSet<>();

        //数字位数
        int L = 10;

        //进制
        int R = 4;

        //存储窗口最高位数
        int RL = (int)Math.pow(R,L - 1);

        //维护滑动窗口中字符串的哈希值
        int windowHash = 0;

        //滑动窗口
        int left = 0, right = 0;
        while(right < nums.length){

            //扩大窗口 移入字符  维护窗口的哈希
            windowHash = R * windowHash + nums[right];
            right++;

            //窗口达到10位数 则开始缩小
            if (right - left == L){

                //根据哈希值判断是否出现过相同的子串
                if (seen.contains(windowHash)){
                    //当前窗口子串是重复出现的
                    res.add(s.substring(left,right));
                }else{
                    //存入seen
                    seen.add(windowHash);
                }

                //缩小窗口 更新windowHash
                windowHash = windowHash - nums[left] * RL;
                left++;
            }


        }
        return new LinkedList<>(res);

    }
}
