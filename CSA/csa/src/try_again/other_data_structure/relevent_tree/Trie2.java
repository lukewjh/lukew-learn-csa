package try_again.other_data_structure.relevent_tree;

/**
 * @author lukew
 * @create 2024-11-06 9:41
 * 1804.实现前缀树II
 */
public class Trie2 {

    TrieMap<Integer> map = new TrieMap<>();

    public void insert(String word){
        if (!map.containsKey(word)){
            map.put(word,1);
        }else{
            map.put(word, map.get(word) + 1);
        }
    }

    public int countWordsEquals(String word){
        if (!map.containsKey(word)){
            return 0;
        }

        return map.get(word);
    }

    public int countWordsStartingWith(String prefix){
        int res = 0;
        for(String key : map.keysWithPrefix(prefix)){
            res += map.get(key);
        }
        return res;
    }

    public void erase(String word){
        int freq = map.get(word);
        if(freq - 1 == 0){
            map.remove(word);
        }else{
            map.put(word, freq - 1);
        }
    }
}
