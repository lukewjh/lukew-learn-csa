package try_again.tree;

import try_again.tree.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-05-31 13:15
 * 95.不同的二叉搜索树II
 */
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n){
        if (n == 0) {
            return new LinkedList<>();
        }

        return build(1, n);
    }


    public List<TreeNode> build(int lo, int hi){
        List<TreeNode> res = new LinkedList<>();

        if(lo > hi){
            //为了构建出为null的叶子结点 必须让返回到上一层时res中有元素 但为null就能顺利构建出叶子结点了
            res.add(null);
            return res;
        }

        //穷举root节点的所有可能
        for(int i = lo; lo <= hi; i++){

            //递归出有效的左右子树
            List<TreeNode> leftTree = build(lo, i - 1);
            List<TreeNode> rightTree = build(i + 1, hi);

            for(TreeNode left : leftTree){
                for(TreeNode right : rightTree){
                    //i作为根节点root的值
                    TreeNode root = new TreeNode();
                    root.left = left;
                    root.right = right;
                    res.add(root);

                }

            }

        }

        return res;


    }
}
