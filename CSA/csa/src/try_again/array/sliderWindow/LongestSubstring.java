package try_again.array.sliderWindow;

/**
 * @author lukew
 * @create 2024-04-29 10:38
 * 395.至少有k个重复字符的最长子串
 */
public class LongestSubstring {

    public int longestSubstring(String s, int k){

        //增加一个字符种类的限制 用于缩小窗口时的判断
        //遍历所有种类的情况即可获取最大长度
        int len = 0;
        for(int i = 1; i < 26; i++){
            //限制窗口内只能有i种不同的字符
            len = Math.max(len,longestKLetterSubstr(s,k,i));
        }

        return len;

    }

    public int longestKLetterSubstr(String s, int k, int count){
        int res = 0;

        int left = 0, right = 0;

        //记录各种字符出现的次数
        int[] windowCount = new int[26];

        //记录窗口中存在几种不同的字符
        int windowUniqueCount = 0;

        //记录窗口中有几种字符的出现次数达标（>=k）
        int windowVaildCount = 0;

        while(right < s.length()){

            char c = s.charAt(right);

            //更新窗口内的数据 更新窗口中已达标的字符
            if (windowCount[c - 'a'] == 0){
                windowUniqueCount++;
            }
            windowCount[c - 'a']++;

            if (windowCount[c - 'a'] == k){
                windowVaildCount++;
            }
            right++;

            //缩小窗口  当窗口中的字符种类大于count时 则开始缩小
            while(windowUniqueCount > count){

                char d = s.charAt(left);
                //更新窗口相关数据
                if (windowCount[d - 'a'] == k){
                    windowVaildCount--;
                }

                windowCount[d - 'a']--;

                if (windowCount[d - 'a'] == 0){
                    windowUniqueCount--;
                }

                left++;

            }

            if (windowVaildCount == count){
                res = Math.max(res,right - left);
            }


        }
        return res;

    }


}
