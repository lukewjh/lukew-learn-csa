package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-05-29 15:18
 * 在BST中插入一个数
 */
public class InsertIntoBST {

    TreeNode insertIntoBST(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }

        if(root.val > val){
            root.left = insertIntoBST(root.left,val);
        }

        if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        }

        return root;

    }
}
