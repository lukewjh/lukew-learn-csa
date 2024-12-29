package try_again.tree.serialize;

import try_again.tree.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lukew
 * @create 2024-05-22 9:31
 * tree结构的层级遍历的序列化和反序列化
 */
public class TreeSerialize3 {

    String NULL = "#";

    String SEP = ",";


    //序列化
    public String serialize3(TreeNode root){

        if (root == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                TreeNode cur = q.poll();

                if (cur == null){
                    sb.append(NULL).append(SEP);
                    continue;
                }

                sb.append(cur.val).append(SEP);

                q.offer(cur.left);
                q.offer(cur.right);
            }
        }

        return sb.toString();

    }

    //反序列化
    public TreeNode deserialize(String data){

        if (data.isEmpty()){
            return null;
        }

        String[] nodes = data.split(SEP);

        //层级遍历中的第一个元素就是根节点root
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int index = 1;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                TreeNode parent = q.poll();

                //为父节点构造左侧子节点
                String left = nodes[index++];
                if (!left.equals(NULL)){
                    parent.left = new TreeNode(Integer.parseInt(left));
                    q.offer(parent.left);
                }

                String right = nodes[index++];
                if (!right.equals(NULL)){
                    parent.right = new TreeNode(Integer.parseInt(right));
                    q.offer(parent.right);
                }

            }

        }
        return root;

    }

}
