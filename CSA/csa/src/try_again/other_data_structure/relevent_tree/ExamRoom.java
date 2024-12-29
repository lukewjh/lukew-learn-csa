package try_again.other_data_structure.relevent_tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author lukew
 * @create 2024-11-12 10:12
 * 855.考场就坐
 */
public class ExamRoom {

    //将端点p映射到以p为左端点的线段
    private Map<Integer,int[]> startMap;

    //将端点p映射到以p为右端点的线段
    private Map<Integer,int[]> endMap;

    //根据线段长度从小到大存放所有线段
    private TreeSet<int[]> pq;

    private int N;


    public ExamRoom(int N){

        this.N = N;
        startMap = new HashMap<>();
        endMap = new HashMap<>();

        pq = new TreeSet<>((a, b) -> {
            int distA = distance(a);
            int distB = distance(b);
            //如果长度相同 就比较索引
            if(distA == distB){
                return b[0] - a[0];
            }
            return distA - distB;
        });

        addInterval(new int[]{-1, N});

    }

    //去除一个线段
    private void removeInterval(int[] intv){
        pq.remove(intv);
        startMap.remove(intv[0]);
        endMap.remove(intv[0]);
    }

    //增加一个线段
    private void addInterval(int[] intv){
        pq.add(intv);
        startMap.put(intv[0], intv);
        endMap.put(intv[1], intv);
    }

    //计算一个线段的长度
    private int distance(int[] intv){
        int x = intv[0];
        int y = intv[1];
        if (x == -1){
            return y;
        }
        if (y == N){
            return N - 1 - x;
        }
        return (y - x) / 2;
    }


    //入座
    public int seat(){
        //从有序集合中取出最长的线段
        int[] longest = pq.last();
        int x = longest[0];
        int y = longest[1];

        int seat;
        if(x == -1){
            seat = 0;
        }else if(y == N){
            seat = N - 1;
        }else{
            seat = (y - x) / 2 + x;
        }

        //将最长的线段分成两段
        int[] left = new int[]{x, seat};
        int[] right = new int[]{seat, y};

        removeInterval(longest);
        addInterval(left);
        addInterval(right);
        return seat;
    }

    public void leave(int p){
        int[] right = startMap.get(p);
        int[] left = endMap.get(p);

        //合并线段
        int[] merged = new int[] {left[0], right[1]};
        removeInterval(left);
        removeInterval(right);
        addInterval(merged);

    }
}
