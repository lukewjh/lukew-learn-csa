package try_again.other_data_structure.hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-09-29 13:36
 * 49.字母异位词分组
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs){
        //编码到分组的映射
        HashMap<String,List<String>> codeToGroup = new HashMap<>();

        for(String s : strs){
            //对字符串进行编码
            String code = encode(s);
            //编码相同的放在一起
            codeToGroup.putIfAbsent(code, new LinkedList<>());
            codeToGroup.get(code).add(s);
        }

        //获取结果
        List<List<String>> res = new LinkedList<>();
        for(List<String> group : codeToGroup.values()){
            res.add(group);
        }

        return res;
    }


    public String encode(String s){
        char[] count = new char[26];
        for(char c : s.toCharArray()){
            int delta = c - 'a';
            count[delta]++;
        }
        return new String(count);

    }
}
