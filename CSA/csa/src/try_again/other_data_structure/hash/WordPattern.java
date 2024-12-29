package try_again.other_data_structure.hash;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author lukew
 * @create 2024-09-20 13:28
 * 290.单词模式
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s){

        String[] words = s.split(" ");

        if (pattern.length() != words.length){
            return false;
        }

        //记录pattern字符到单词的映射
        HashMap<Character,String> patternToWord = new HashMap<>();

        //记录哪些已经有pattern对应的单词
        HashSet<String> wordSet = new HashSet<>();

        for(int i = 0; i < pattern.length(); i++){

            char c = pattern.charAt(i);

            String word = words[i];
            if (!patternToWord.containsKey(c)){

                if (wordSet.contains(word)){
                    return false;
                }

                patternToWord.put(c,word);
            }else{

                if (!patternToWord.get(c).equals(word)){
                    return false;
                }
            }

            wordSet.add(word);

        }
        return true;

    }

}
