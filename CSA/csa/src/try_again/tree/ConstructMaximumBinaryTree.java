package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-05-17 10:03
 * 654.最大二叉树
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums){
        return build(nums,0,nums.length - 1);
    }

    public TreeNode build(int[] nums, int lo, int hi){
        //分解子问题的思路
        //找出最大值 根节点 再分别找出左右子树的根节点

        if (lo > hi){
            return null;
        }

        //找到数组中的最大值 和对应的索引
        int index = -1;
        int maxVal = Integer.MIN_VALUE;
        for(int i = lo; i <= hi; i++){
            if (maxVal < nums[i]){
                index = i;
                maxVal = nums[i];
            }

        }

        //构造当前子数组的根节点
        TreeNode root = new TreeNode(maxVal);

        //递归调用左右子树
        root.left = build(nums,lo,index - 1);
        root.right = build(nums,index + 1,hi);

        return root;


    }
}
