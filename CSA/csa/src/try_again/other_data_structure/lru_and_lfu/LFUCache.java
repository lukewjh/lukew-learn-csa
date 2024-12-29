package try_again.other_data_structure.lru_and_lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author lukew
 * @create 2024-09-19 10:00
 * 460.LFU算法( Least Frequently Used)
 */
public class LFUCache {

    //key到val的映射
    HashMap<Integer,Integer> keyToVal;

    //key到freq的映射
    HashMap<Integer,Integer> keyToFreq;

    //frq到key列表的映射
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    //记录最小的频次
    int minFreq;

    //记录LFU缓存的最大容量
    int cap;


    public LFUCache(int capacity){
        keyToFreq = new HashMap<>();
        keyToVal = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key){

        if (!keyToVal.containsKey(key)){
            return -1;
        }
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int val){

        if (this.cap <= 0){
            return;
        }

        //若key已存在 修改对应的val
        if (keyToVal.containsKey(key)){
            keyToVal.put(key,val);
            increaseFreq(key);
            return;
        }

        //key不存在则需要插入
        //先检查容量是否已满 容量满了需要淘汰一个最小的频率key
        if (this.cap <= keyToVal.size()){
            removeMinFreqKey();
        }

        //插入操作
        keyToVal.put(key,val);
        keyToFreq.put(key,1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        //插入新的key  minFreq的值设为1
        this.minFreq = 1;
    }


    private void removeMinFreqKey(){

        //freq最小的key列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);

        //最先被插入的那个key就是最旧该被淘汰的
        int deletedKey = keyList.iterator().next();


        //更新FK表
        keyList.remove(deletedKey);
        if (keyList.isEmpty()){
            freqToKeys.remove(minFreq);
        }

        //更新KV
        keyToVal.remove(deletedKey);
        //更新KF
        keyToFreq.remove(deletedKey);
    }


    private void increaseFreq(int key){

        int freq = keyToFreq.get(key);

        //更新KF
        keyToFreq.put(key,freq + 1);

        //更新FK
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);

        //更新freq
        if (freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            if (freq == this.minFreq){
                this.minFreq++;
            }
        }

    }
}
