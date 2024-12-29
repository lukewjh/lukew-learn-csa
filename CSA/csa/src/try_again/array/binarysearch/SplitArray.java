package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-05-06 13:26
 * 410.分割数组中的最大值
 */
public class SplitArray {


    //把题目可以使用1011题目一样的思想

    //当值为x时，需要分割f(x)次
    public int f(int[] nums, int x){

        int count = 0;
        for(int i = 0; i < nums.length;){

            int cap = x;
            while(i < nums.length){
                if (cap < nums[i]){
                    break;
                }else{
                    cap -= nums[i];
                }
                i++;

            }

            count++;

        }
        return count;

    }


    public int splitArray(int[] nums, int k){

        //初始化最小值 最大值
        int left = 0;
        int right = 1;

        for(int num : nums){
            right += num;
            left = Math.max(left,num);
        }

        while(left < right){

            int mid = left + (right - left) / 2;
            if (f(nums,mid) == k){
                right = mid;
            }else if(f(nums, mid) < k){
                right = mid;
            }else if(f(nums,mid) > k){
                left = mid + 1;
            }


        }

        return left;
    }


}
