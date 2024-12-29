package try_again.other_data_structure.exercise;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author lukew
 * @create 2024-11-29 9:58
 * 379.电话目录管理系统
 */
public class PhoneDirectory {

    private LinkedList<Integer> available = new LinkedList<>();

    private HashSet<Integer> used = new HashSet<>();

    public PhoneDirectory(int maxNumBer){
        for(int i = 0; i < maxNumBer; i++){
            available.addLast(i);
        }
    }

    public int get(){
        if (available.isEmpty()){
            return -1;
        }

        //随机取出一个号码 并标记已使用
        int number = available.removeLast();
        used.add(number);
        return number;
    }

    public boolean check(int number){
        return !used.contains(number);
    }

    public void release(int number){
        if(used.contains(number)){
            used.remove(number);
            available.addLast(number);
        }
    }
}
