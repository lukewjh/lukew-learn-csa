package try_again.array.sliderWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-04-10 14:52
 * 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s){

        Map<Character,Integer> window = new HashMap<>();

        int res = 0;

        int left = 0;
        int right = 0;

        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c,window.getOrDefault(c,0)+1);

            while(window.get(c) > 1){
                char d = s.charAt(left);
                left++;

                window.put(d,window.get(d)-1);

            }

            res = Math.max(res,right-left);
        }

        return res;
    }

}
