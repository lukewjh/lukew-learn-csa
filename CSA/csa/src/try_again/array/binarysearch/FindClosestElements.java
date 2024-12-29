package try_again.array.binarysearch;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-05-07 8:47
 * 658.找到k个最接近的元素
 */
public class FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x){

        //找到x 的左边界位置
        int p = leftBound(arr,x);

        int left = p - 1;
        int right = p;

        LinkedList<Integer> res = new LinkedList<>();

        //扩展区间 直到区间包含k个元素
        while(right - left - 1 < k){

            if(left == -1){
                res.addLast(arr[right]);
                right++;
            }else if (right == arr.length){
                res.addFirst(arr[left]);
                left--;
            }else if(x - arr[left] > arr[right] - x){
                res.addLast(arr[right]);
                right++;
            }else{
                res.addFirst(arr[left]);
                left--;
            }

        }
        return res;


    }

    //二分搜索到x的左边界位置
    int leftBound(int[] nums, int target){

        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid;
            }
        }

        return left;
    }
}
