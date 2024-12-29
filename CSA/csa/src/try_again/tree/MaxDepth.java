package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-05-14 8:55
 * 104.二叉树的最大深度
 */
public class MaxDepth {

    //分解子问题的方式求解

    int maxDepth(TreeNode root){

        if (root == null){
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        //判断左右子树的最大深度 加上自己这个节点
        int res = Math.max(leftMax,rightMax) + 1;

        return res;


    }
}
