package tree;

/**
 * @author lukew
 * @create 2024-03-04 16:20
 * 查找二叉树
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(4);

        System.out.println(bst.find(2).left.val);
        System.out.println(bst.find(2).right.val);


    }


    //根节点
    Node tree;


    //查找
    public Node find(int data){
        if (tree == null) return null;
        Node p = tree;
        while( p != null ){
            if (data > p.val){
                p = p.right;
            }else if (data < p.val){
                p = p.left;
            }else{
                return p;
            }
        }
        return null;
    }



    //新增节点
    public void insert(int data){

        if (tree == null){
            tree = new Node(data);
            return;
        }

        //找到适合放节点的位置
        Node p = tree;
        while(p != null){
            //如果大于则放在右节点
            if (data > p.val){
                if (p.right == null){
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }else{
                if (p.left == null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }

        }

    }







    //树节点
    static class Node{

        //值
        int val;
        //左右子节点
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }



}
