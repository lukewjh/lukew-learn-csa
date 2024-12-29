package try_again.other_data_structure.exercise;

import java.util.Iterator;

/**
 * @author lukew
 * @create 2024-12-02 14:17
 * 284.窥视迭代器
 */
public class PeekingIterator implements Iterator<Integer>{

    private Iterator<Integer> iter;
    //将迭代器的下一个元素提前拿出来并缓存
    private Integer nextElem;

    public PeekingIterator(Iterator<Integer> iterator){
        this.iter = iterator;
        this.nextElem = iterator.next();
    }

    public Integer peek(){
        return nextElem;
    }

    @Override
    public boolean hasNext() {
        return nextElem != null;
    }

    @Override
    public Integer next() {
        Integer res = nextElem;
        if (iter.hasNext()){
            nextElem = iter.next();
        }else{
            nextElem = null;
        }

        return res;
    }
}
