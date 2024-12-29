package try_again.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lukew
 * @create 2024-04-15 17:23
 * 18.四数之和
 */
public class FourSum {


    //四数之和 = 三数之和 + 另一个数
    List<List<Integer>> fourSum(int[] nums,long target){
        Arrays.sort(nums);

        int n = nums.length ;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<List<Integer>> tuples = threeSumTarget(nums, i + 1, target - nums[i]);
            for(List<Integer> tuple : tuples){
                tuple.add(nums[i]);
                res.add(tuple);
            }

            while(nums[i] == nums[i+1] && i < n - 1){
                i++;
            }

        }
        return res;

    }


    //三数之和
    List<List<Integer>> threeSumTarget(int[] nums,int start,long target){
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = start; i < n;i++){
            List<List<Integer>> tuples = twoSumTarget(nums,i + 1,target - nums[i]);

            for(List<Integer> tuple : tuples){
                tuple.add(nums[i]);
                res.add(tuple);
            }

            while(i < n - 1 && nums[i] == nums[i+1]){
                i++;
            }
        }

        return res;

    }

    //两数之和
    List<List<Integer>> twoSumTarget(int[] nums,int start,long target){

        int left = start;
        int right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();

        while(left < right){
            int sum = nums[left] + nums[right];

            int leftV = nums[left];
            int rightV = nums[right];

            if (sum > target){
                while(left < right && nums[right] == rightV){
                    right--;
                }
            }else if(sum < target){
                while(left < right && nums[left] == leftV){
                    left++;
                }
            }else{
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[left]);
                pair.add(nums[right]);
                res.add(pair);

                while(left < right && nums[left] == leftV){
                    left++;
                }
                while(left < right && nums[right] == rightV){
                    right--;
                }

            }
        }

        return res;

    }
}
