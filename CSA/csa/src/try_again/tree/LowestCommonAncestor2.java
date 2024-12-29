package try_again.tree;

import try_again.tree.util.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lukew
 * @create 2024-06-04 11:05
 * 1676.二叉树的最近公共祖先IV
 */
public class LowestCommonAncestor2 {

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes){

        //变体1：找到这个nodes列表中所有节点的公共祖先
        HashSet<Integer> values = new HashSet<>();
        for(TreeNode node : nodes){
            values.add(node.val);
        }

        return find(root,values);

    }

    TreeNode find(TreeNode root, HashSet<Integer> values){

        if (root == null){
            return null;
        }

        //前序
        if (values.contains(root.val)){
            return root;
        }

        //左右子树看看
        TreeNode left = find(root.left, values);
        TreeNode right = find(root.right, values);

        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;

    }
}
