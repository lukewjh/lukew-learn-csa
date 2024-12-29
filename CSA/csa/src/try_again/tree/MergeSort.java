package try_again.tree;

/**
 * @author lukew
 * @create 2024-05-22 13:32
 * 912.排序数组
 */
public class MergeSort {

    //创建临时数组 用于保存合并前的数据
    int[] temp;

    public int[] sortArray(int[] nums){
        temp = new int[nums.length];
        //使用归并排序
        sort(nums, 0, nums.length - 1);

        return nums;

    }

    public void sort(int[] nums, int lo, int hi){

        if (lo == hi){
            return ;
        }

        //从中点区分开来排序
        int mid = lo + (hi - lo) / 2;

        //先排序左半部分
        sort(nums, lo, mid);
        //再排序右边
        sort(nums, mid + 1, hi);

        //合并
        merge(nums,lo,mid,hi);

    }

    //将两个有序数组合并成一个有序数组
    public void merge(int[] nums, int lo, int mid, int hi){

        //先把nums[lo...hi]复制到临时数组中  以便合并后的结果直接存入到 nums原数组中
        for(int i = lo; lo <= hi; i++){
            temp[i] = nums[i];
        }

        //双指针合并两个有序数组
        int i = lo;
        int j = mid + 1;

        for(int p = lo; p <= hi; p++){
            if (i == mid + 1){
                //证明左边数组已经合并好了 也就是nums[lo...mid]合并完了 接下来合并nums[mid + 1...hi]
                nums[p] = temp[j++];
            }else if (j == hi + 1){
                //证明右边数组已经合并完毕
                nums[p] = temp[i++];
            }else if(temp[i] > temp[j]){
                nums[p] = temp[j++];
            }else{
                nums[p] = temp[i++];
            }
        }


    }
}
