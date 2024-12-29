package try_again.other_data_structure.hash;

/**
 * @author lukew
 * @create 2024-09-27 14:21
 * 242.有效的字母异位词
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t){
        int[] count1 = encode(s);
        int[] count2 = encode(t);
        //确保两个字符串中所有字符出现的数量相同
        for(int i = 0; i < count1.length; i++){
            if (count1[i] != count2[i]){
                return false;
            }
        }

        return true;
    }


    //计算字符出现的次数
    int[] encode(String s){
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            int delta = c - 'a';
            count[delta]++;
        }
        return count;

    }
}
