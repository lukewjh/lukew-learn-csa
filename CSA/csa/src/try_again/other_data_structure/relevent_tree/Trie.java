package try_again.other_data_structure.relevent_tree;

/**
 * @author lukew
 * @create 2024-10-31 9:15
 * 208.实现Trie树（字符串前缀树）
 */
public class Trie {

    TrieSet set = new TrieSet();

    //插入下一个元素
    public void insert(String word){
        set.add(word);
    }

    //判断是否在集合中
    public boolean search(String word){
        return set.contains(word);
    }

    //判断集合中是否有前缀为prefix的元素
    public boolean startsWith(String prefix){
        return set.hasKeyWithPrefix(prefix);
    }
}
