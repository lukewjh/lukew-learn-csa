package try_again.array.sliderWindow;

/**
 * @author lukew
 * @create 2024-04-28 16:17
 * 424.替换后的最长重复字符
 */
public class CharacterReplacement {

    public int characterReplacement(String s, int k){

        //滑动窗口
        int left = 0;
        int right = 0;

        //统计窗口中每个字符出现的个数
        int[] windowCharCount = new int[26];


        //记录窗口中字符的最多重复次数
        int windowMaxCount = 0;

        int res = 0;

        while(right < s.length()){

            //扩大窗口
            windowCharCount[s.charAt(right) - 'A']++;
            windowMaxCount = Math.max(windowMaxCount,windowCharCount[s.charAt(right) - 'A']);

            while(right - left - windowMaxCount > k){
                //缩小窗口
                windowCharCount[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res,right - left);

        }
        return res;

    }
}
