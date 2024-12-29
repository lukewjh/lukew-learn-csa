package try_again.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lukew
 * @create 2024-04-15 14:21
 * 15.三数之和
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums){
        return threeSumTarget(nums,0);
    }

    //求三数之和就是求 两数之和+另一个数 == target
    public List<List<Integer>> threeSumTarget(int[] nums,int target){

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0;i < n;i++){
            //重点：三数之和拆成了 两数之和+当前数
            List<List<Integer>> tuples = twoSum(nums,i + 1,target-nums[i]);
            //如果上面的target-nums[i]的两数之和存在的话
            for(List<Integer> tuple:tuples){
                tuple.add(nums[i]);
                res.add(tuple);
            }

            //跳过已加入
            while(i < n-1 && nums[i] == nums[i+1]){
                i++;
            }

        }
        return res;

    }

    //两数之和
    public List<List<Integer>> twoSum(int[] nums,int start,int target){
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

            }else if (sum < target){
                while(left < right && nums[left] == leftV){
                    left++;
                }
            }else{
                List<Integer> pair = new ArrayList<>();
                pair.add(leftV);
                pair.add(rightV);
                while(left < right && nums[left] == leftV){
                    left++;
                }
                while(left < right && nums[right] == rightV){
                    right--;
                }
                res.add(pair);
            }

        }
        return res;

    }


}
