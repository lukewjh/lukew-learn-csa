package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-05-29 10:34
 * 98.验证是否是二叉树
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root){

        return isValidBST(root,null,null);

    }

    public boolean isValidBST(TreeNode root, TreeNode max, TreeNode min){

        if(root == null){
            return true;
        }

        //当前root节点的范围必须在(min...max)区间 才满足BST要求
        if (min != null && root.val <= min.val){
            return false;
        }
        if(max != null && root.val >= max.val){
            return false;
        }

        //当前节点左子树的最大数 就是当前节点   当前节点的右子树的小值也是当前节点
        return isValidBST(root.left,root,min) && isValidBST(root.right,max,root);

    }
}
