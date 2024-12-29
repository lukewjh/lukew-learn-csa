package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-06-04 13:11
 *
 * 1644.二叉树的最近公共祖先II
 */
public class LowestCommonAncestor3 {

    boolean foundP = false;
    boolean foundQ = false;

    //和之前找公共祖先逻辑一样 但是需要对p、q节点进行全树搜索
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        TreeNode res = find(root, p.val, q.val);
        if (!foundP || !foundQ){
            return null;
        }

        //只有p和q都在树中 才有公共祖先
        return res;

    }

    TreeNode find(TreeNode root, int val1, int val2){

        if (root == null){
            return null;
        }

        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);

        //后序位置判断当前节点是否是LCA节点
        if (left != null && right != null){
            return root;
        }

        if (root.val == val1 || root.val == val2){
            if (root.val == val1) foundP = true;
            if (root.val == val2) foundQ = true;
            return root;
        }

        return left != null ? left : right;


    }


}
