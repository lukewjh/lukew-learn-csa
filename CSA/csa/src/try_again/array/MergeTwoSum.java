package try_again.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lukew
 * @create 2024-04-15 13:31
 * 合并两数之和 得到所有相加为目标值的对数 且不重复
 * （合并两数之和通用版）
 */
public class MergeTwoSum {

    List<List<Integer>> twoSumTarget(List<Integer> nums,int target){

        //排序
        Collections.sort(nums);

        //左右指针
        int left = 0;
        int right = nums.size() - 1;

        List<List<Integer>> res = new ArrayList<>();

        while(left < right){

            int sum = nums.get(left) + nums.get(right);
            //记录左右指针的值  用于跳过重复值做对比
            int leftV = nums.get(left);
            int rightV = nums.get(right);

            if (sum < target){
                while(left< right && nums.get(left) == leftV){
                    left++;
                }
            }else if(sum > target){
                while(left < right && nums.get(right) == rightV){
                    right--;
                }
            }else{
                //两数之和与target相等
                res.add(Arrays.asList(leftV,rightV));
                //跳过相等的值  不需要继续对比
                while(left < right && nums.get(left) == leftV){
                    left++;
                }
                while(left < right && nums.get(right) == rightV){
                    right--;
                }
            }

        }
        return res;

    }

}
