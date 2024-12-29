package try_again.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-05-23 9:15
 * 315.计算右侧小于当前元素的个数
 */
public class CountSmaller {

    private class Pair{
        int val;
        int id;
        Pair(int val, int id){
            this.val = val;
            this.id = id;
        }

    }

    //归并排序用的辅助数组
    private Pair[] temp;

    //记录元素后面比自己小的元素个数
    private int[] count;


    public List<Integer> countSmaller(int[] nums){

        int n = nums.length;
        count = new int[n];
        temp = new Pair[n];

        Pair[] arr = new Pair[n];
        //记录元素原始的索引位置  以便在count数组中更新结果
        for(int i = 0; i < n; i++){
            arr[i] = new Pair(nums[i],i);
        }

        sort(arr, 0, n - 1);

        List<Integer> res = new LinkedList<>();
        for (int c : count){
            res.add(c);
        }

        return res;

    }


    public void sort(Pair[] arr, int lo, int hi){

        if (lo == hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr,lo,mid,hi);

    }

    public void merge(Pair[] arr, int lo, int mid, int hi){
        for(int i = lo; i <= hi; i++){
            temp[i] = arr[i];
        }

        int i = lo;
        int j = mid + 1;

        for(int p = lo; p <= hi; p++){
            if (i == mid + 1){
                arr[p] = temp[j++];
            }else if (j == hi + 1){
                arr[p] = temp[i++];
                //更新count数组 因为在合并过程中 右半部分都走完了的话
                //说明右半部分的所有值都小于左半部分的temp[i] 即当前小于索引p的右侧个数为 左半部分(j - mid - 1)
                count[arr[p].id] += j - mid - 1;
            }else if (temp[i].val > temp[j].val){
                arr[p] = temp[i++];
            }else{
                arr[p] = temp[i++];
                count[arr[p].id] += j - mid - 1;
            }

        }

    }
}
