package try_again.other_data_structure.relevent_tree;

import java.util.List;

/**
 * @author lukew
 * @create 2024-11-04 10:27
 * 648.单词替换
 */
public class ReplaceWords {

    String replaceWords(List<String> dict, String sentence){

        //将词根存入TrieSet
        TrieSet set = new TrieSet();
        for(String key : dict){
            set.add(key);
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");

        for(int i = 0; i < words.length; i++){
            //在Trie树中搜索最短词根
            String prefix = set.shortestPrefixOf(words[i]);

            if(!prefix.isEmpty()){
                sb.append(prefix);
            }else{
                sb.append(words[i]);
            }

            if(i != words.length - 1){
                sb.append(' ');
            }
        }

        return sb.toString();

    }
}
