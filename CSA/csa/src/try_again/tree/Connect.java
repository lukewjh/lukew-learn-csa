package try_again.tree;

import try_again.tree.util.Node;
import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-05-15 10:44
 * 116.填充节点的右侧指针
 */
public class Connect {

    Node connect(Node root){
        if (root == null){
            return null;
        }

        //将完全二叉树 抽象成三叉树进行遍历
        traverse(root.left,root.right);
        return root;

    }

    private void traverse(Node node1, Node node2) {

        if (node1 == null || node2 == null){
            return;
        }

        //将node1的指针指向node2
        node1.next = node2;

        //三叉树遍历
        traverse(node1.left,node2.right);
        traverse(node1.right,node2.left);
        traverse(node2.left,node2.right);


    }
}
