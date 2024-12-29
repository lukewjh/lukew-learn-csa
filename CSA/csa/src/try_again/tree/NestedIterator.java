package try_again.tree;

import try_again.tree.util.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lukew
 * @create 2024-06-03 17:09
 * 341.扁平化嵌套列表迭代器
 */
public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList){

        List<Integer> result = new LinkedList<>();

        //思想是多叉树的遍历  叶子结点就是res
        for(NestedInteger node : nestedList){
            traverse(node,result);
        }

        this.it = result.iterator();

    }


    @Override
    public Integer next(){
        return it.next();
    }

    @Override
    public boolean hasNext(){
        return it.hasNext();
    }

    private void traverse(NestedInteger root, List<Integer> result){
        if(root.isInteger()){
            //到达叶子几点
            result.add(root.getInteger());
            return;
        }

        for(NestedInteger child : root.getList()){
            traverse(child, result);
        }

    }


}
