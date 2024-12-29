package try_again.other_data_structure.queue;

import java.util.NoSuchElementException;

/**
 * @author lukew
 * @create 2024-06-14 9:13
 * 622.设计循环队列（数组）
 */
class ArrayQueue<E> {

    private int size = 0;
    private E[] data ;

    private final static int INIT_CAP = 2;

    private int first;
    private int last;

    public ArrayQueue(int initCap){
        size = 0;
        data = (E[]) new Object[initCap];
        first = last = 0;
    }

    public ArrayQueue(){
        this(INIT_CAP);
    }

    /*增*/
    public void enqueue(E e){
        if(size == data.length){
            resize(size * 2);
        }

        data[last] = e;
        last++;

        if (last == data.length){
            last = 0;
        }

        size++;
    }

    /*删*/
    public E dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }

        if (size == data.length / 4) {
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

    /*查*/
    public E peekFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return data[first];
    }


    public E peekLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        if (last == 0){
            return data[data.length - 1];
        }
        return data[last - 1];
    }

    public int size(){
        return size;
    }


    public boolean isEmpty(){
        return size == 0;
    }


    /*扩容*/
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


public class MyCircularQueue{
    ArrayQueue<Integer> q;
    int maxCap;

    public MyCircularQueue(int k){
        q = new ArrayQueue<>(k);
        maxCap = k;
    }

    public boolean enQueue(int value){
        if(q.size() == maxCap){
            return false;
        }

        q.enqueue(value);
        return true;
    }

    public boolean deQueue(){
        if (q.isEmpty()){
            return false;
        }
        q.dequeue();
        return true;
    }

    public int Front(){
        if(q.isEmpty()){
            return -1;
        }
        return q.peekFirst();

    }

    public int Rear(){
        if (q.isEmpty()){
            return -1;
        }
        return q.peekLast();
    }

    public boolean isEmpty(){
        return q.isEmpty();
    }

    public boolean isFull(){
        return q.size() == maxCap;
    }
}
