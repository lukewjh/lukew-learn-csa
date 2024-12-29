package try_again.tree;

import try_again.tree.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-05-20 10:45
 * 889.根据前序和后序遍历结果构造二叉树
 */
public class BuildTree3 {

    Map<Integer,Integer> valToIndex = new HashMap<>();


    TreeNode constructFromPrePost(int[] preorder, int[] postorder){

        for(int i = 0; i < postorder.length; i++){
            valToIndex.put(postorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);

    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] postorder, int postStart, int postEnd){

        if (preStart > preEnd){
            return null;
        }

        if (preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }

        //找到root节点  就是前序遍历的第一个元素
        int rootVal = preorder[preStart];

        //root.left 就是前序排列第二个元素
        //通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
        int leftRootVal = preorder[preStart + 1];

        //leftRootVal 在后续遍历中对应的下标
        int index = valToIndex.get(leftRootVal);

        //然后就能计算出左子树的个数
        int leftSize = index - postStart + 1;

        //创建当前根节点 递归所有的左右子树
        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder,preStart + 1,preStart + leftSize,
                            postorder,postStart,index);
        root.right = build(preorder,preStart + leftSize + 1, preEnd,
                            postorder,index + 1, postEnd - 1);

        return root;

    }
}
