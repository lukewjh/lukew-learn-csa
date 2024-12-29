package try_again.other_data_structure.relevent_tree;

import java.util.List;

/**
 * @author lukew
 * @create 2024-10-30 14:44
 * TrieSet
 */
public class TrieSet {


    private final TrieMap<Object> map = new TrieMap<>();

    //增
    public void add(String key){
        map.put(key, new Object());
    }

    //删
    public void remove(String key){
        map.remove(key);
    }

    //查
    public boolean contains(String key){
        return map.containsKey(key);
    }

    //在集合中寻找query最短前缀
    public String shortestPrefixOf(String query){
        return map.shortestPrefixOf(query);
    }

    //在集合中寻找query最长前缀
    public String longestPrefixOf(String query){
        return map.longestPrefixOf(query);
    }

    //在集合中找到前缀为prefix的所有元素
    public List<String> keysWithPrefix(String prefix){
        return map.keysWithPrefix(prefix);
    }

    //判断集合中是否存在前缀为prefix的元素
    public boolean hasKeyWithPrefix(String prefix){
        return map.hasKeyWithPrefix(prefix);
    }

    //通配符.匹配任意字符，返回集合中匹配pattern所有元素
    public List<String> keysWithPattern(String pattren){
        return map.keysWithPattern(pattren);
    }

    //通配符.匹配任意字符，判断集合中是否存在匹配pattern的元素
    public boolean hasKeyWithPattern(String pattern){
        return map.hasKeyWithPattern(pattern);
    }

    //返回集合中的个数
    public int size(){
        return map.size();
    }
}
