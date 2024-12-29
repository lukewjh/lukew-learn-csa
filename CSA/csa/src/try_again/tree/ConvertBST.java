package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-05-29 9:42
 * 538.把二叉搜索树转换为累加树
 * 1038.从二叉搜索树到更大和树
 */
public class ConvertBST {

    public TreeNode convertBST(TreeNode root){

        traverse(root);
        return root;
    }

    int sum = 0;
    public void traverse(TreeNode root){
        //中序遍历的降序排列计算累加和

        if(root == null){
            return;
        }

        traverse(root.right);

        //累加右边树
        sum += root.val;
        root.val = sum;

        traverse(root.left);
    }
}
