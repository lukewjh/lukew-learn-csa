package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-03-21 14:23
 */
public class BackTrack {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> resNums = permute(nums);
        for (List a:resNums){
            System.out.println(a);
        }
    }

    static List<List<Integer>> res = new LinkedList<>();

    /**
     * 输入一组不重复的数字  返回他们的全排列
     */
    static List<List<Integer>> permute(int[] nums){
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums,track);
        return res;
    }


    /**
     * 路径： track
     * 选择列表： nums 中不存在与track的那些元素
     * 结束条件：nums中的元素全部都在track中出现
     */
    static void backTrack(int[] nums, LinkedList<Integer> track){

        //触发结束条件
        if (track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            //排除不合法的选择
            if (track.contains(nums[i])){
                continue;
            }

            //做选择
            track.add(nums[i]);
            //递归进入决策树继续做选择
            backTrack(nums,track);
            //返回到上一次的选择
            track.removeLast();

        }

    }
}
