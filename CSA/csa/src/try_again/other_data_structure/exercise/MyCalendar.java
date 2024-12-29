package try_again.other_data_structure.exercise;

import java.util.TreeMap;

/**
 * @author lukew
 * @create 2024-11-18 10:08
 * 729.我的日程安排表
 */
public class MyCalendar {

    private TreeMap<Integer,Integer> calendar = new TreeMap<>();

    public MyCalendar(){

    }

    public boolean book(int start, int end){

        Integer earlier = calendar.floorKey(start);
        Integer later = calendar.ceilingKey(start);

        if (later != null && end > later){
            return false;
        }

        if (earlier != null && start < calendar.get(earlier)){
            return false;
        }

        calendar.put(start,end);
        return true;

    }
}
