package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-05-15 9:57
 * 226.翻转二叉树
 */
public class InvertTree {


    /**
     * 遍历方式
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root){

        traverse(root);
        return root;
    }

    public void traverse(TreeNode root){

        if (root == null){
            return ;
        }

        //交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //递归
        traverse(root.left);
        traverse(root.right);

    }

    /**
     * 分解子问题
     */
    public TreeNode invertTree2(TreeNode root){

        if (root == null){
            return null;
        }

        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);

        return root;

    }


}
