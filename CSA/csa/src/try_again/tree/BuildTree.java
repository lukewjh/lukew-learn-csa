package try_again.tree;

import try_again.tree.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-05-17 11:17
 * 105.从前序与中序遍历序列构造二叉树
 */
public class BuildTree {

    //使用HashMap记录inorder根的索引
    Map<Integer,Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preOrder, int[] inOrder){

        for(int i = 0; i < inOrder.length; i++){
            valToIndex.put(inOrder[i],i);
        }

        return build(preOrder,0,preOrder.length - 1,inOrder, 0, inOrder.length - 1);

    }

    public TreeNode build(int[] preOrder, int preStart, int preEnd,
                            int[] inOrder, int inStart, int inEnd){

        if (preStart > preEnd){
            return null;
        }

        //根节点就是 preOrder的第一个
        int rootVal = preOrder[preStart];

        //获取根节点在inOrder中的索引
        Integer index = valToIndex.get(rootVal);

        //计算leftSize  从而得出 preOrder中左右子树的分界线
        int leftSize = index - inStart;

        //构造当前的根节点
        TreeNode root = new TreeNode(rootVal);

        //递归左右子树
        root.left = build(preOrder,preStart + 1, preStart + leftSize, inOrder, inStart, index - 1);
        root.right = build(preOrder, preStart + leftSize + 1, preEnd, inOrder, index + 1, inEnd);

        return root;

    }


}
