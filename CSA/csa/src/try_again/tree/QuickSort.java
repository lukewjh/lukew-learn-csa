package try_again.tree;

import java.util.Random;

/**
 * @author lukew
 * @create 2024-06-03 11:06
 */
public class QuickSort {


    public void sort(int[] nums){

        //避免快排的极端情况 随机打乱
        shuffle(nums);

    }

    public void sort(int[] nums, int lo, int hi){
        if(lo >= hi){
            return;
        }
        int p = partition(nums,lo,hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);

    }

    //对nums[lo...hi]进行切分
    public int partition(int[] nums, int lo, int hi){

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

            if (i >= j){
                break;
            }

            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;


    }



    //洗牌算法
    private void shuffle(int[] nums){
        Random rand = new Random();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            //生成[i,n-1]随机数
            int r = i + rand.nextInt(n - 1);
            swap(nums, i, r);
        }

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
