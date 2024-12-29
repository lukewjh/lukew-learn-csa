package try_again.tree.util;

import try_again.tree.NestedIterator;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-06-03 17:24
 * 341.扁平化嵌套列表迭代器 (惰性版)
 */
public class NestedIterator2 {

    private LinkedList<NestedInteger> list;

    public NestedIterator2(List<NestedInteger> nestedList){

        list = new LinkedList<>(nestedList);
    }

    public Integer next(){
        return list.remove(0).getInteger();
    }

    public boolean hasNext(){
        //循环拆分列表元素，直到列表第一个元素是整数类型
        while(!list.isEmpty() && !list.get(0).isInteger()){
            List<NestedInteger> first = list.remove(0).getList();
            //将第一个列表打平 按顺序添加到开头
            for(int i = first.size() - 1; i >= 0; i--){
                list.addFirst(first.get(i));
            }

        }

        return !list.isEmpty();
    }
}
