package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-05-28 9:57
 * 230.二叉搜索树中第k小的元素
 */
public class kthSmallest {

    public int kthSmallest(TreeNode root, int k){

        //bst的中序遍历就是升序遍历
        traverse(root,k);
        return res;

    }

    //记录结果
    int res = 0;
    //记录当前元素的排名
    int rank = 0;

    public void traverse(TreeNode root, int k){

        if (root == null){
            return;
        }

        traverse(root.left,k);
        //------------------
        rank++;
        if (k == rank){
            res = root.val;
            return;
        }
        //------------------
        traverse(root.right,k);


    }
}
