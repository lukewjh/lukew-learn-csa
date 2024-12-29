package try_again.array.sliderWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-04-10 10:05
 * 567.字符串的排列
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 *
 */
public class CheckInclusion {

    public boolean checkInclusion(String s,String t){

        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();


        for (char c : t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }

        //窗口索引
        int left = 0;
        int right = 0;
        //窗口中需要满足的字符数量
        int valid = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            right++;

            //维护窗口
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (need.get(c).equals(window.get(c))){
                    valid++;
                }
            }

            //长度和valid同时满足  则满足题解
            //长度一旦大于等于t的长度  就需要判断 是否满足need.size() == valid
            while(right - left >= t.length()){
                if (need.size() == valid){
                    return true;
                }

                char d = s.charAt(left);
                left++;
                //更新窗口
                if (need.containsKey(d)){
                    if (need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return false;

    }
}
