package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-05-16 9:18
 * 114.二叉树展开为链表
 */
public class Flatten {

    void flatten(TreeNode root){

        if (root == null){
            return ;
        }

        flatten(root.left);
        flatten(root.right);


        TreeNode left = root.left;
        TreeNode right = root.right;

        //将当前节点的左子树置空
        root.left = null;
        root.right = left;

        //连接到当前节点的右子树末端
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }

        p.right = right;

    }
}
