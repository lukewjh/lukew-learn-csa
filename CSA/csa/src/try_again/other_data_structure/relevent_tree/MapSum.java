package try_again.other_data_structure.relevent_tree;

import java.util.List;

/**
 * @author lukew
 * @create 2024-11-07 9:34
 * 677.键值映射
 */
public class MapSum {


    TrieMap<Integer> map = new TrieMap<>();

    public void insert(String key, int val){
        map.put(key,val);
    }

    public int sum(String prefix){

        List<String> keys = map.keysWithPrefix(prefix);
        int res = 0;

        for(String key : keys){
            res += map.get(key);
        }

        return res;

    }
}
