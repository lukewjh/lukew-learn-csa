package try_again.tree;

import try_again.tree.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-05-15 9:40
 * 用递归的方法层序遍历
 */
public class LevelTraverse2 {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> levelTraverse(TreeNode root){

        if (root == null){
            return res;
        }

        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        traverse(nodes);
        return res;

    }

    private void traverse(List<TreeNode> curLevelNodes) {

        if (curLevelNodes.isEmpty()){
            return;
        }

        //前序位置  计算当前层的值和下一层的节点列表
        List<Integer> nodesValues = new LinkedList<>();
        List<TreeNode> nextLevelNodes = new LinkedList<>();

        for(TreeNode node : curLevelNodes){
            nodesValues.add(node.val);
            if (node.left != null){
                nextLevelNodes.add(node.left);
            }
            if (node.right != null){
                nextLevelNodes.add(node.right);
            }

        }

        //添加当前层的结果到res
        res.add(nodesValues);
        traverse(nextLevelNodes);

    }
}
