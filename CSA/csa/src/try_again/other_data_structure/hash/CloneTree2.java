package try_again.other_data_structure.hash;

import try_again.other_data_structure.hash.util.TreeNode;

import java.util.ArrayList;

/**
 * @author lukew
 * @create 2024-09-25 9:45
 * 1490.克隆N叉树 (递归)
 */
public class CloneTree2 {

    public TreeNode cloneTree(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode cpRoot = new TreeNode(root.val);

        cpRoot.children = new ArrayList<>();
        for(TreeNode child : root.children){
            cpRoot.children.add(cloneTree(child));
        }

        return cpRoot;
    }
}
