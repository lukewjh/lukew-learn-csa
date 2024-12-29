package try_again.array;

import java.util.*;

/**
 * @author lukew
 * @create 2024-05-09 14:45
 * 380.O(1)时间 插入、删除 和 获取随机元素
 */
public class RandomizedSet {

    //存储元素值的数组
    List<Integer> nums;

    //存储值对应下标的哈希表
    Map<Integer,Integer> valToIndex;

    //初始化
    public RandomizedSet(){
        nums = new ArrayList<>();
        valToIndex = new HashMap<>();
    }

    //O(1)插入
    public boolean insert(int val){
        //如果已经存在则返回false
        if (valToIndex.containsKey(val)){
            return false;
        }
        //存入nums  valToIndex
        int n = nums.size();
        valToIndex.put(val,n);
        nums.add(val);
        return true;

    }


    //O(1)删除
    public boolean remove(int val){

        //不存在 则不用再删除
        if (!valToIndex.containsKey(val)){
            return false;
        }

        //获取对应下标
        int index = valToIndex.get(val);

        //将最后一个元素对应的索引修改为index
        valToIndex.put(nums.get(nums.size() - 1), index);

        //置换index和最后一个下标的值
        Collections.swap(nums,index,nums.size() - 1);

        //删除最后一个值
        nums.remove(nums.size() - 1);

        //删除val对应的索引
        valToIndex.remove(val);
        return true;

    }

    //O(1)随机获取
    public int getRandom(){
        return nums.get((int) (Math.random() * nums.size()));
    }
}
