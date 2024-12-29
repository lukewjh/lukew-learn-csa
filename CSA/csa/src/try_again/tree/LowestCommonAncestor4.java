package try_again.tree;

import try_again.tree.util.Node2;

/**
 * @author lukew
 * @create 2024-06-04 13:38
 * 1650.二叉树的最近公共祖先
 */
public class LowestCommonAncestor4 {

    Node2 lowestCommonAncestor4(Node2 p, Node2 q){

        //将Node2中的parent指针想成单链表的next指针 这两个链表一定会相交 求交点
        //单链表的求相交点
        //单链表A走完就走B 相等的节点就是节点

        Node2 a = p;
        Node2 b = q;
        while(a != b){
            if (a == null){
                a = q;
            }else{
                a = a.parent;
            }

            if(b == null){
                b = p;
            }else{
                b = b.parent;
            }

        }

        return a;
    }
}
