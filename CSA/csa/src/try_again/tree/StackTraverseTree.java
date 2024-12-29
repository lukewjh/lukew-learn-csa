package try_again.tree;

import try_again.tree.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author lukew
 * @create 2024-06-06 9:20
 * 使用迭代的方式遍历二叉树 并找出其前中后序
 */
public class StackTraverseTree {


    private Stack<TreeNode> stk = new Stack<>();

    //左子树一路到底
    private void pushLeftBranch(TreeNode p){
        while(p != null){
            /**
             * 前序遍历的代码位置
             */
            stk.push(p);
            p = p.left;
        }
    }

    public List<Integer> traverse(TreeNode root){

        //指向上一次遍历完的子树节点
        TreeNode visited = new TreeNode(-1);

        List<Integer> postorder = new ArrayList<>();

        //开始遍历整棵树
        pushLeftBranch(root);

        while(!stk.isEmpty()){
            TreeNode p = stk.peek();

            //p的左子树遍历完了 右子树还没遍历过
            if ((p.left == null || p.left == visited) && p.right != visited){
                /**
                 * 中序遍历位置
                 */
                pushLeftBranch(p.right);
            }

            //p的右子树遍历完了
            if (p.right == null || p.right == visited){
                /**
                 * 后序遍历位置
                 */
                postorder.add(p.val);
                visited = stk.pop();
            }
        }
        return postorder;


    }

}
