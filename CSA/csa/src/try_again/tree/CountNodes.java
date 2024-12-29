package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-06-05 9:07
 * 222.计算完全二叉树的节点数
 */
public class CountNodes {

    public int countNodes(TreeNode root){

        TreeNode l = root;
        TreeNode r = root;

        //先判断是否是满二叉树 满二叉树 是完全二叉树的一种特殊情况 能快速的知道节点数量

        int hl = 0;
        int hr = 0;

        while(l != null){
            l = l.left;
            hl++;
        }

        while(r != null){
            r = r.right;
            hr++;
        }

        //如果左右两子树的高度相同证明当前节点是满二叉树
        if(hl == hr){
            return (int) Math.pow(2,hl) - 1;
        }

        //若不满足满二叉树 则使用普通遍历的方式 计算
        return 1 + countNodes(root.left) + countNodes(root.right);


    }
}
