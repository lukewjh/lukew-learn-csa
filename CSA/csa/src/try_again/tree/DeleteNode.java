package try_again.tree;

import try_again.tree.util.TreeNode;

/**
 * @author lukew
 * @create 2024-05-29 15:37
 * 删除BST中的节点
 */
public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key){

        //1.找到要删除的节点位置
        //2.删除分为三种情况  （无子节点）（一个子节点）（两个子节点）
        if(root == null){
            return null;
        }

        if(root.val == key){
            //删除逻辑  三种不同的情况对应不同的删除方式

            //情况1、2
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }

            //情况3
            //获得右子树最小值节点
            TreeNode minNode = getMin(root.right);
            //删除右子树最小节点
            root.right = deleteNode(root.right,minNode.val);

            //右子树的最小节点替换当前节点
            minNode.left =  root.left;
            minNode.right = root.right;

            root = minNode;

        }else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }

        return root;

    }

    TreeNode getMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

}
