package try_again.other_data_structure.relevent_tree;

/**
 * @author lukew
 * @create 2024-11-05 9:17
 * 211.添加与搜索单词
 */
public class WordDictionary {

    TrieSet set = new TrieSet();

    public void addWord(String word){
        set.add(word);
    }

    //通配符匹配
    public boolean search(String word){
        return set.hasKeyWithPattern(word);
    }
}
