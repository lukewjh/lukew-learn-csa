package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-06-04 9:57
 *
 * 236.二叉树的最近公共祖先
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //利用先后序位置
        return find(root, p.val, q.val);

    }

    public TreeNode find(TreeNode root, int val1, int val2){
        if (root == null){
            return null;
        }

        //判断当前节点是否是满足条件的节点
        if(root.val == val1 || root.val == val2){
            return root;
        }

        //再从左右子树中找  如果子树中有两个节点都满足 那当前的root节点就是最近公共祖先
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right,val1,val2);

        //在后序位置
        if (left != null && right != null){
            return root;
        }

        return left != null ? left : right;


    }
}
