package stringmatchalgorithm;

/**
 * @author lukew
 * @create 2024-03-14 10:16
 *
 * Trie树的实现
 */
public class Trie {

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insertNode(new char[]{'g','o','o','d'});
        System.out.println(t.find(new char[]{'g', 'o', 'o', 'd'}));
    }

    //根节点不需要存储字符
    private TrieNode root = new TrieNode('/');


    //插入一个字符串
    public void insertNode(char[] text){
        TrieNode p = root;
        for (int i = 0; i < text.length;i++){
            //通过计算字符的ASCII值来存放对应的下标位置
            int index = text[i] - 'a';
            if (p.children[index] == null){
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];

        }
        p.isEndingChar = true;
    }

    //查找
    public boolean find(char[] pattern){
        TrieNode p = root;
        for (int i = 0;  i < pattern.length; i++){
            int index = pattern[i] - 'a';
            if (p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }

        if (p.isEndingChar) {
            return true;
        }else{
            //这个字符串在Trie中不是完全匹配的，只是前缀
            return false;
        }


    }


    static class TrieNode{
        char data;
        TrieNode children[] = new TrieNode[26];
        boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
