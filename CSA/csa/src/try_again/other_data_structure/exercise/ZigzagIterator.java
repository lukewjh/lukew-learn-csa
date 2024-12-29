package try_again.other_data_structure.exercise;

import java.util.List;

/**
 * @author lukew
 * @create 2024-12-03 9:17
 * 281.锯齿迭代器
 */
public class ZigzagIterator {

    private int i = 0, j = 0;

    private List<Integer> list1, list2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2){
        this.list1 = v1;
        this.list2 = v2;
    }

    public int next(){
        if (i <= j){
            if (i < list1.size()){
                return list1.get(i++);
            }else{
                return list2.get(j++);
            }
        }else{
            if (j < list2.size()){
                return list2.get(j++);
            }else{
                return list1.get(i++);
            }
        }
    }

    public boolean hasNext(){
        //两个指针任意一个每遍历完就证明没完
        return i < list1.size() || j < list2.size();
    }
}
