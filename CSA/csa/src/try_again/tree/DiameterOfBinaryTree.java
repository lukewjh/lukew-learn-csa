package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-05-14 10:31
 * 543.二叉树的直径
 */
public class DiameterOfBinaryTree {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root){
        maxDepth(root);
        return maxDiameter;
    }

    //求左右子树的最大深度相加
    public int maxDepth(TreeNode root){

        if (root == null){
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        //在后序位置更新最大直径 （左子树深度+右子树深度）
        int myDiameter = maxLeft + maxRight;
        maxDiameter = Math.max(myDiameter,maxDiameter);

        return 1 + Math.max(maxLeft,maxRight);

    }
}
