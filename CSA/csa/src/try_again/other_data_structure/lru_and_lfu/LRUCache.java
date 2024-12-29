package try_again.other_data_structure.lru_and_lfu;

import java.util.HashMap;

/**
 * @author lukew
 * @create 2024-09-18 14:38
 * 146.哈希链表（LRU Least Recently Used 最少最新使用缓存淘汰算法）
 */
public class LRUCache {

    //哈希表
    private HashMap<Integer,Node> map;

    //缓存
    private DoubleList cache;

    private int cap;


    public LRUCache(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }


    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }

        //将key对应的数据提升为最近使用
        makeRecently(key);
        return map.get(key).val;

    }


    public void put(int key, int val){
        if (map.containsKey(key)){
            //删除旧数据 提前此数据
            deleteKey(key);
            addRecently(key,val);
            return;
        }

        if (cap == cache.size()) {
            removeLeastRecently();
        }

        addRecently(key, val);


    }





    /**------------------以下为map和cache的封装操作*/


    //将某个key提升为最近使用
    private void makeRecently(int key){
        Node x = map.get(key);
        //先删后插
        cache.remove(x);
        cache.addLast(x);
    }

    //添加最近使用的元素
    private void addRecently(int key, int val){
        Node x = new Node(key,val);
        //链表尾部就是最近使用的元素
        cache.addLast(x);
        map.put(key,x);
    }

    //删除某一个key
    private void deleteKey(int key){
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    //删除最久未使用的元素
    private void removeLeastRecently(){
        Node deletedNode = cache.removeFirst();
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }
}
