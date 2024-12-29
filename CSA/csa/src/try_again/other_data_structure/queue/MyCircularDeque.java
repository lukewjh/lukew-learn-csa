package try_again.other_data_structure.queue;

/**
 * @author lukew
 * @create 2024-06-17 9:21
 * 641.设计循环双端队列
 */

/**
 * 双端队列数据结构
 * @param <E>
 */
class MyArrayDeque<E>{

    private int size;
    private E[] data;
    private final static int INIT_CAP = 2;

    private int first;
    private int last;

    public MyArrayDeque(int initCap){

        size = 0;
        data = (E[]) new Object[initCap];

        first = last = 0;

    }

    public MyArrayDeque(){
        this(INIT_CAP);
    }

    //从头部获取元素
    public E getFirst(){
        if(isEmpty()){
            throw new RuntimeException();
        }

        return data[first];
    }

    //从尾部获取元素
    public E getLast(){
        if (isEmpty()){
            throw new RuntimeException();
        }
        if (last == 0){
            return data[data.length - 1];
        }
        return data[last - 1];
    }

    //从头部插入
    public void addFirst(E e){
        if (size == data.length){
            resize(size * 2);
        }

        if(first == 0){
            first = data.length - 1;
        }else{
            first--;
        }

        data[first] = e;
        size++;
    }

    //从尾部插入
    public void addLast(E e){
        if (size == data.length){
            resize(size * 2);
        }

        data[last] = e;
        last++;
        if (last == data.length){
            last = 0;
        }

        size++;
    }

    //从头部删除元素
    public E removeFirst(){
        if (isEmpty()){
            throw new RuntimeException();
        }

        if (size == data.length / 4){
            resize(data.length / 2);
        }

        E oldVal = data[first];
        data[first] = null;

        first++;
        if (first == data.length){
            first = 0;
        }

        size--;
        return oldVal;
    }

    //从尾部删除元素
    public E removeLast(){
        if (isEmpty()){
            throw new RuntimeException();
        }

        if (size == data.length / 4){
            resize(data.length / 2);
        }

        if (last == 0){
            last = data.length - 1;
        }else{
            last--;
        }

        E oldVal = data[last];

        //删除元素
        data[last] = null;

        size--;
        return oldVal;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void resize(int newCap){
        E[] temp = (E[]) new Object[newCap];

        for(int i = 0; i < size; i++){
            temp[i] = data[(first + i) % data.length];
        }

        first = 0;
        last = size;
        data = temp;

    }



}
public class MyCircularDeque {

    private int cap;
    private MyArrayDeque<Integer> list = new MyArrayDeque<>();

    public MyCircularDeque(int k){
        this.cap = k;
    }

    public boolean insertFront(int value){

        if (list.size() == cap){
            return false;
        }

        list.addFirst(value);
        return true;

    }

    public boolean insertLast(int value){
        if (list.size() == cap){
            return false;
        }

        list.addLast(value);
        return true;
    }

    public boolean deleteLast(){
        if (list.isEmpty()){
            return false;
        }

        list.removeLast();
        return true;
    }

    public int getFront(){
        if (list.isEmpty()){
            return -1;
        }

        return list.getFirst();
    }

    public int getRear(){
        if (list.isEmpty()){
            return -1;
        }

        return list.getLast();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public boolean isFull(){
        return list.size() == cap;
    }






}
