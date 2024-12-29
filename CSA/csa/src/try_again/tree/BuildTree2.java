package try_again.tree;

import try_again.tree.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-05-17 13:20
 *
 * 106.从中序与后序遍历序列构造二叉树
 */
public class BuildTree2 {

    Map<Integer,Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree2(int[] postorder, int[] inorder){

        for(int i = 0; i < inorder.length; i++){
            valToIndex.put(inorder[i], i);
        }

        return build(postorder,0,postorder.length - 1,inorder,0,inorder.length - 1);
    }

    public TreeNode build(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd){

        if (postStart > postEnd) {
            return null;
        }

        //从后序列表中获取根节点
        int rootValue = postorder[postEnd];

        //从找到根节点在中序列表中对应的索引值
        int index = valToIndex.get(rootValue);

        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootValue);

        //左右子树
        root.left = build(postorder, postStart, postStart + leftSize, inorder, inStart, index - 1);
        root.right = build(postorder,postStart + leftSize + 1, postEnd - 1,inorder, index + 1, inEnd);

        return root;
    }
}
