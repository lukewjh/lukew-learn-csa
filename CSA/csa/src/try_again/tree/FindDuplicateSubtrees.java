package try_again.tree;

import try_again.tree.util.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author lukew
 * @create 2024-05-21 10:17
 * 652.寻找重复的子树
 */
public class FindDuplicateSubtrees {


    //记录所有子树以及出现的次数
    Map<String,Integer> subTrees = new HashMap<>();

    //记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root){

        //解决两个问题：
        //1.如何记录一个树的结构 -- 序列化
        //2.如何知道其他节点的树是否有这个结构 -- hashMap

        serialize(root);
        return res;

    }

    public String serialize(TreeNode root){

        if (root == null) {
            return "#";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);

        String myself = left + "," + right + "," + root.val;

        //存入hashmap
        int freq = subTrees.getOrDefault(myself, 0);

        //结果集中只添加一次
        if (freq == 1){
            res.add(root);
        }

        subTrees.put(myself,freq + 1);
        return myself;

    }
}
