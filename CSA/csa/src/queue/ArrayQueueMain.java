package queue;

/**
 * @author lukew
 * @create 2024-02-21 9:31
 * 数组实现的队列
 */
public class ArrayQueueMain {

    static class ArrayQueue{

        //队列数组
        String[] items;
        //数组大小
        int n = 0;

        int head = 0;
        int tail = 0;


        //申请一个大小为n的数组

        public ArrayQueue(int capacity) {
            items = new String[capacity];
            n = capacity;
        }


        //出队
        public String dequeue(){
            if (head == tail){
                throw new RuntimeException("队空");
            }
            String value = items[head];
            head ++;
            return value;

        }

        //入队
        public boolean enqueue(String val){
            if (tail == n){
                if (head == 0){
                    System.out.println("队列真的满了");
                    return false;
                }
                System.out.println("队满--开始数据搬移");
                //队满时开始做数据搬移操作
                for (int i = head; i < tail ;++i){
                    items[i-head] = items[i];
                }
                //搬完更新head和tail
                tail -= head;
                head = 0;



            }
            items[tail] = val;
            tail ++;
            return true;
        }

        public void printAll(){
            System.out.println("头指针：" + head);
            System.out.println("尾指针：" + tail);
            for ( int i = 0; i < items.length; i++){
                System.out.println(items[i]);
            }
        }


    }


    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(5);
        System.out.println(aq.enqueue("a"));
        System.out.println(aq.enqueue("b"));
        System.out.println(aq.enqueue("c"));
        System.out.println(aq.enqueue("d"));

        aq.printAll();

        //出队
        System.out.println(aq.dequeue());

        aq.printAll();

        System.out.println(aq.enqueue("e"));
        aq.printAll();

        System.out.println(aq.enqueue("f"));
        aq.printAll();


    }


}
