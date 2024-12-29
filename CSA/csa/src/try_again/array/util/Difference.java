package try_again.array.util;

/**
 * @author lukew
 * @create 2024-04-23 9:32
 *
 * 差分数组工具类
 */
public class Difference {

    //差分数组
    private int[] diff;

    public Difference(int[] nums){
        assert nums.length > 0;
        diff = new int[nums.length];
        //构造差分数组
        diff[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    //给闭区间增加val
    public void increment(int i, int j,int val){
        diff[i] += val;
        if (j + 1 < diff.length){
            diff[j + 1] -= val;
        }
        //当j + 1>diff.length时  就说明对nums[i]及后面的整个数组进行修改  就不需要给diff减val

    }


    //返回结果数组
    public int[] result(){
        int[] res = new int[diff.length];
        //根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++){
            res[i] = diff[i] + res[i - 1];
        }

        return res;
    }
}
