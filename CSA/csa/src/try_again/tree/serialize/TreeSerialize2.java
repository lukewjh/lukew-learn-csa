package try_again.tree.serialize;

import try_again.tree.util.TreeNode;

import java.util.LinkedList;

/**
 * @author lukew
 * @create 2024-05-21 15:04
 *
 * tree结构后序遍历的序列化和反序列化
 */
public class TreeSerialize2 {

    String NULL = "#";

    String SEP = ",";

    //序列化
    public String serialize2(TreeNode root){

        StringBuilder sb = new StringBuilder();

        serialize(root,sb);

        return sb.toString();
    }

    public void serialize(TreeNode root,StringBuilder sb){


        if (root == null){
            sb.append(NULL).append(SEP);
            return ;
        }

        //后序遍历 序列化
        serialize(root.left, sb);
        serialize(root.right, sb);

        sb.append(root.val).append(SEP);

    }

    //反序列化
    public TreeNode deserialize2(String data){

        //序列化后的字符串转成list
        LinkedList<String> nodes = new LinkedList<>();

        for(String s : data.split(SEP)){
            nodes.addLast(s);
        }

        return deserialize(nodes);

    }


    public TreeNode deserialize(LinkedList<String> nodes){
        if (nodes.isEmpty()){
            return null;
        }

        //因为序列化的时候是后序排列的方式进行序列化的  所以根节点是list中的最后一个元素
        String last = nodes.removeLast();

        if (last.equals(NULL)){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(last));
        //构造左右子树
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;

    }


}
