package try_again.array.sliderWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-04-09 10:58
 * 76.求字符串s中包含字符串t所有字符的最小子串
 *
 */
public class MinWindow {

    public String minWindow(String s,String t){

        //使用hash表记录s串的滑动窗口和t串出现的字符出现次数
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        //统计t串中字符出现次数
        for(Character c : t.toCharArray()){
            need.put(c,need.getOrDefault(c,0) + 1);
        }

        int left = 0,right = 0;
        //窗口中满足需要的字符个数
        int valid = 0;
        //记录最小覆盖子串的起始索引及长度
        int start = 0,len = Integer.MAX_VALUE;

        //更新窗口右侧索引的相关逻辑
        while(right < s.length()){
            //新移入窗口的字符
            char c = s.charAt(right);
            //扩大窗口
            right++;

            //进行窗口数据的更新
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0)+1);
                //只有当window[c]和need[c]的个数相同时 valid++
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            //更新窗口的左侧索引逻辑(判断左侧窗口是否要收缩)
            while(valid == need.size()){
                //更新最小覆盖子串
                if (right - left < len){
                    start = left;
                    len = right - left;
                }

                //d是将要 移出窗口的字符
                char d = s.charAt(left);

                //窗口缩小
                left++;

                //窗口中数据的更新
                if (need.containsKey(d)){
                    // 只有当 window[d] 内的出现次数和 need[d] 相等时，才能 -1
                    if (need.get(d).equals(window.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }

        }




        return len == Integer.MAX_VALUE ? "":s.substring(start,start+len);

    }
}
