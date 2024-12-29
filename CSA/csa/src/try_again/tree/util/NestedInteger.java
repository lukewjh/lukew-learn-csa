package try_again.tree.util;

import java.util.List;

/**
 * @author lukew
 * @create 2024-06-03 17:04
 * n叉树数据结构
 */
public class NestedInteger {

    private Integer val;

    private List<NestedInteger> list;

    public NestedInteger(Integer val) {
        this.val = val;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list){
        this.list = list;
        this.val = null;
    }


    public boolean isInteger(){
        return val != null;
    }

    public Integer getInteger(){
        return this.val;
    }

    public List<NestedInteger> getList(){
        return this.list;
    }


}
