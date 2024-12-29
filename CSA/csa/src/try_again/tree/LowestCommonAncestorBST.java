package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-06-04 13:26
 * 235.BST的最近公共节点
 */
public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q){
        //在BST中找公共祖先 首先要利用 左小右大的特性  如果满足 p.val < root.val < q.val 那么root就是p、q的最近公共祖先
        //确认p、q的谁大谁小
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return find(root, val1, val2);

    }

    public TreeNode find(TreeNode root, int val1, int val2){
        if(root == null){
            return null;
        }

        if (root.val > val2){
            //当前的节点太大  去左树找
            return find(root.left, val1, val2);
        }

        if (root.val < val1){
            return find(root.right, val1, val2);
        }

        //如果满足 p.val < root.val < q.val
        return root;

    }
}
