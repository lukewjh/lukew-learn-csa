package try_again.tree;

import java.util.Random;

/**
 * @author lukew
 * @create 2024-06-03 13:25
 * 215.数组中第k个最大元素
 */
public class FindKthLargest {

    int findKthLargest(int[] nums, int k){
        //利用快速排序算法的分区方法对第k大的元素快速定位
        shuffle(nums);

        int lo = 0;
        int hi = nums.length - 1;

        //将第k大的元素转为 排名第k的元素
        k = nums.length - k;

        while(lo <= hi){
            int p = partition(nums, lo, hi);

            //根据分区后的定位
            if(p < k){
                lo = p + 1;
            }else if(p > k){
                hi = p - 1;
            }else{
                //找到
                return nums[p];
            }

        }

        return -1;

    }

    //切分
    int partition(int[] nums, int lo, int hi){
        int pivot = nums[lo];

        int i = lo + 1;
        int j = hi;
        while(i <= j){
            while(i < hi && nums[i] <= pivot){
                i++;
            }

            while(j > lo && nums[j] > pivot){
                j--;
            }

            if(i >= j){
                break;
            }

            swap(nums, i, j);

        }

        swap(nums, lo, j);

        return j;
    }

    //数组洗牌算法
    void shuffle(int[] nums){
        Random rand = new Random();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);

        }
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
