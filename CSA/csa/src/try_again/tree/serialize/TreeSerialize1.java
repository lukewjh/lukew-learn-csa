package try_again.tree.serialize;

import try_again.tree.util.TreeNode;

import java.util.LinkedList;

/**
 * @author lukew
 * @create 2024-05-21 11:12
 *
 * tree结构前序遍历的序列化和反序列化
 */
public class TreeSerialize1 {

    String SEP = ",";

    String NULL = "#";


    //序列化
    public String treeSerialize1(TreeNode root){

        StringBuilder sb = new StringBuilder();
        serialize(root, sb);

        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append(NULL).append(SEP);
            return;
        }

        //前序位置 对每个节点进行序列化
        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);

    }



    //反序列化
    public TreeNode deserialize1(String data){
        //将字符串转成 列表
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(SEP)){
            nodes.addLast(s);
        }

        return deserialize(nodes);

    }

    TreeNode deserialize(LinkedList<String> nodes){
        if (nodes.isEmpty()){
            return null;
        }

        //因为是前序遍历的序列化 列表最左侧的是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;

    }



}
