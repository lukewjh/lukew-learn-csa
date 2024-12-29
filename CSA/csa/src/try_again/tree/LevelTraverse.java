package try_again.tree;

import try_again.tree.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lukew
 * @create 2024-05-14 11:40
 * 层序遍历
 */
public class LevelTraverse {

    void levelTraverse(TreeNode root){
        if (root == null){
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        //从上到下遍历二叉树的每一层

        while(!q.isEmpty()){
            int sz = q.size();
            for (int i = 0; i < sz; i++){
                TreeNode cur = q.poll();

                //将下一层的节点放入队列中
                if (cur.left != null){
                    q.offer(cur.left);
                }

                if (cur.right != null){
                    q.offer(cur.right);
                }
            }
        }
    }
}
