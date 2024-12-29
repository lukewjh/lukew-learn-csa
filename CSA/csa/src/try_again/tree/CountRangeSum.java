package try_again.tree;

/**
 * @author lukew
 * @create 2024-05-24 9:39
 * 327.区间和的个数
 */
public class CountRangeSum {

    private int lower;
    private int upper;

    private long[] temp;

    private int count = 0;

    public int countRangeSum(int[] nums, int lower, int upper){

        this.lower = lower;
        this.upper = upper;

        //构造前缀和数组
        long[] preSum = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            preSum[i + 1] = (long)nums[i] + preSum[i];
        }

        //利用归并排序的特性找到满足题目的元素和
        sort(preSum);
        return count;


    }

    public void sort(long[] nums){
        temp = new long[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    public void sort(long[] nums, int lo, int hi){

        if (lo == hi){
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums,mid + 1, hi);
        merge(nums,lo,mid,hi);

    }

    public void merge(long[] nums, int lo, int mid, int hi){
        //初始化当前的temp
        for(int i = lo; i < hi; i++){
            temp[i] = nums[i];
        }

        //在合并操作前找到元素和
        //维护左闭右开区间[start,end) 中的元素和nums[i] 的差在[lower,upper]中
        int start = mid + 1;
        int end = mid + 1;

        for(int i = lo; i <= mid; i++){
            //更新start end
            //nums[start] - nums[i] 求区间[start..i]的元素和
            while(start <= hi && nums[start] - nums[i] < lower){
                start++;
            }

            while(end <= hi && nums[end] - nums[i] <= upper){
                end++;
            }

            count += end - start;
        }

        //双指针 完成合并操作
        int i = lo;
        int j = mid + 1;

        for(int p = lo; p <= hi; p++){
            if(i == mid + 1){
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                nums[p] = temp[i++];
            }else if(nums[i] > nums[j]){
                nums[p] = temp[j++];
            }else{
                nums[p] = temp[i++];
            }

        }
    }
}
