package try_again.tree;

/**
 * @author lukew
 * @create 2024-05-23 11:27
 * 493.翻转对
 */
public class ReversePairs {

    int count = 0;

    int[] temp;

    public int reversePairs(int[] nums){

        int n = nums.length;
        temp = new int[n];
        sort(nums, 0, n - 1);

        return count;

    }

    public void sort(int[] nums, int lo, int hi){
        if(lo == hi){
            return ;
        }
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums,lo,mid,hi);

    }

    public void merge(int[] nums, int lo, int mid, int hi){

        //保存到辅助数组中
        for(int i = lo; i <= hi; i++){
            temp[i] = nums[i];
        }

        //在合并之前是否有满足条件的  并更新count
        int end = mid + 1;
        for(int i = lo; i <= mid; i++){
            //找到右半边(已排序)小于nums[i]的所有索引
            while(end <= hi && (long) nums[i] > (long) nums[end] * 2){
                end++;
            }
            //这个区间就是满足条件的
            count += end - (mid + 1);
        }

        //继续双指针合并
        int i = lo;
        int j = mid + 1;

        for(int p = lo; p <= hi; p++){
            if(j == hi + 1){
                nums[p] = temp[i++];
            }else if(i == mid + 1){
                nums[p] = temp[j++];
            }else if(temp[i] > temp[j]){
                nums[p] = temp[j++];
            }else{
                nums[p] = temp[i++];
            }

        }


    }
}
