package try_again.other_data_structure.hash;

import java.util.HashMap;
import java.util.Random;

/**
 * @author lukew
 * @create 2024-09-23 10:26
 * 519.随机翻转矩阵
 */
public class RandomReserveMatrix {

    int m, n;

    //矩阵抽象变成一维的长度
    int len;

    HashMap<Integer,Integer> deletedToExist;

    Random random = new Random();

    public RandomReserveMatrix(int n, int m){
        this.n = n;
        this.m = m;
        this.len = m * n;
        this.deletedToExist = new HashMap<>();
    }

    public int[] flip(){
        int rand = random.nextInt(len);

        int res = rand;
        if (deletedToExist.containsKey(rand)){
            res = deletedToExist.get(rand);
        }

        //将rand换到数组尾部
        int last = len - 1;

        if(deletedToExist.containsKey(last)){
            last = deletedToExist.get(last);
        }

        deletedToExist.put(rand,last);
        return new int[] {res / n, res % n};

    }

    public void reset(){
        this.len = this.m * this.n;
        this.deletedToExist.clear();
    }
}
