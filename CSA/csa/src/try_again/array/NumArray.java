package try_again.array;

/**
 * @author lukew
 * @create 2024-04-16 14:19
 * 303.区域和检索-数组不可变
 */
public class NumArray {

    private int[] preSum;

    public NumArray(int[] nums){
        //前缀和初始化
        preSum = new int[nums.length + 1];

        for(int i = 1;i < preSum.length; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    //查询前缀和的闭区间
    public int sumRange(int left,int right){

        return preSum[right + 1] - preSum[left];
    }
}
