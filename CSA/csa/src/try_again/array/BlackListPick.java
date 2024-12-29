package try_again.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-05-10 13:11
 * 710.黑名单中的随机数
 */
public class BlackListPick {

    //非黑名单的元素长度
    int sz;
    //黑名单中的元素映射 下标
    Map<Integer, Integer> mapping;

    public BlackListPick(int N, int[] blacklist){

        //计算非黑名单的元素长度
        sz = N - blacklist.length;
        mapping = new HashMap<>();

        for (int b : blacklist){
            mapping.put(b,111);
        }

        int last = N - 1;
        for(int b : blacklist){

            if (b >= sz){
                continue;
            }

            while(mapping.containsKey(last)){
                last--;
            }

            //更新mapping
            mapping.put(b,last);
            last--;

        }
    }

    public int pick(){

        //随机选取一个索引
        int index = (int) (Math.random() * sz);

        //这个索引命中了黑名单的话需要映射到其他位置
        if (mapping.containsKey(index)){
            return mapping.get(index);
        }

        return index;


    }
}
