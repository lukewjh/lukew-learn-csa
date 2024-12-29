package try_again.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-04-16 9:00
 *     n数之和
 *     统一
 */
public class NSum {

    public List<List<Integer>> nSumTarget(List<Integer> nums, int n, int start, long target){

        int sz = nums.size();

        List<List<Integer>> res = new ArrayList<>();

        if (n < 2 || sz < n){
            return res;
        }

        //base case 是两数之和
        if (n == 2){

            //双指针
            int left = start;
            int right = sz - 1;
            while(left < right){
                int sum = nums.get(left) + nums.get(right);

                int leftV = nums.get(left);
                int rightV = nums.get(right);

                if (sum > target){
                    while(left < right && nums.get(right) == rightV){
                        right--;
                    }
                }else if(sum < target){
                    while(left < right && nums.get(left) == leftV){
                        left++;
                    }
                }else{
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums.get(left));
                    pair.add(nums.get(right));

                    res.add(pair);

                    while(left < right && nums.get(right) == rightV){
                        right--;
                    }
                    while(left < right && nums.get(left) == leftV){
                        left++;
                    }
                }
            }


        }else{

            //n > 2时 递归计算n-1sum
            for(int i = start;i < sz;i++){
                List<List<Integer>> sub = nSumTarget(nums,n - 1,i + 1,target - nums.get(i));

                for(List<Integer> arr : sub){
                    arr.add(nums.get(i));
                    res.add(arr);
                }

                while(i < sz - 1 && nums.get(i).equals(nums.get(i+1))){
                    i++;
                }
            }

        }
        return res;

    }


}
