package try_again.other_data_structure.hash;


import try_again.other_data_structure.hash.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author lukew
 * @create 2024-09-25 9:15
 * 1490.N叉树克隆 (遍历)
 */
public class CloneTree {

    HashMap<TreeNode, TreeNode> nodeToCopy = new HashMap<>();

    public TreeNode cloneTree(TreeNode root){
        traverse1(root);
        traverse2(root);
        return nodeToCopy.get(root);
    }



    //第一次遍历  构造每个节点的克隆
    void traverse1(TreeNode root){

        if(root == null){
            return;
        }

        //拷贝节点 存到nodeToCopy
        TreeNode cpRoot = new TreeNode(root.val);
        nodeToCopy.put(root,cpRoot);

        //多叉树遍历存入
        for(TreeNode child : root.children){
            traverse1(child);
        }

    }

    //第二次遍历组装节点结构
    void traverse2(TreeNode root){

        if(root == null){
            return;
        }

        TreeNode cpRoot = nodeToCopy.get(root);
        cpRoot.children = new ArrayList<>();
        for(TreeNode child : root.children){
            cpRoot.children.add(nodeToCopy.get(child));
        }

        for(TreeNode child : root.children){
            traverse2(child);
        }

    }
}
