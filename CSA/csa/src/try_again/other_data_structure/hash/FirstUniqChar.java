package try_again.other_data_structure.hash;

/**
 * @author lukew
 * @create 2024-09-29 14:04
 * 387.字符串中的第一个唯一字符
 */
public class FirstUniqChar {

    public int firstUniqChar(String s){
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(count[c - 'a'] == 1){
                return i;
            }
        }

        return -1;

    }
}
