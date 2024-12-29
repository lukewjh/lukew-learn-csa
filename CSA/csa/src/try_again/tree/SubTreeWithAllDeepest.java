package try_again.tree;

import javafx.util.Pair;
import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-06-04 14:29
 * 865.具有所有最深节点的最小子树
 */
public class SubTreeWithAllDeepest {

    public TreeNode subTreeWithAllDeepest(TreeNode root){

        //因为最小的深度是0  返回得到的最深子树的深度的最小子树
        return dfs(root).getKey();
    }

    public Pair<TreeNode,Integer> dfs(TreeNode root){
        if(root == null){
            //到达最底层 返回深度为0
            return new Pair<>(null, 0);
        }

        //递归左右子树
        Pair<TreeNode,Integer> leftResult = dfs(root.left);
        Pair<TreeNode,Integer> rightResult = dfs(root.right);

        //左右子树对比  返回更深的子树  如果两个树深度相同 则返回当前节点
        if(leftResult.getValue() > rightResult.getValue()){
            return new Pair<>(leftResult.getKey(), leftResult.getValue() + 1);
        }else if(rightResult.getValue() > leftResult.getValue()){
            return new Pair<>(rightResult.getKey(), rightResult.getValue() + 1);
        }else {
            //相同的话 返回当前节点 深度是子树深度 + 1
            return new Pair<>(root, leftResult.getValue() + 1);
        }


    }
}
