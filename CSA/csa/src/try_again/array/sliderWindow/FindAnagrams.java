package try_again.array.sliderWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-04-10 14:15
 * 438. 找到字符串中所有字母异位词
 */
public class FindAnagrams {


    public List<Integer> findAnagrams(String s,String t){

        List<Integer> res = new ArrayList<>();
        //返回每个异位词的起始索引
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window  = new HashMap<>();

        for(char c : t.toCharArray()){
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left = 0;
        int right = 0;

        int valid = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            while(right - left >= t.length()){

                if (need.size() == valid){
                    res.add(left);
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }

            }
        }
        return res;

    }
}
