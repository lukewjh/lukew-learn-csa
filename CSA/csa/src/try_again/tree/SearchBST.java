package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-05-29 14:51
 * 700.BST中搜索元素
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int target){

        if(root == null){
            return null;
        }

        if(root.val > target){
            return searchBST(root.left,target);
        }

        if (root.val < target){
            return searchBST(root.right, target);
        }

        return root;

    }


}
