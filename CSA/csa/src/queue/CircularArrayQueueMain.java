package queue;

/**
 * @author lukew
 * @create 2024-02-21 14:44
 *
 * 环形顺序队列
 */
public class CircularArrayQueueMain {


    static class CircularArrayQueue{
        //循环队列减少了数据搬移的操作
        //形成一个循环队列 关键点在于 队空和队满的判定
        //队满：(tail+1)%n == head
        //队空则是 head == tail

        String[] items;

        int head = 0;
        int tail = 0;

        int n = 0;

        public CircularArrayQueue(int capacity){
            items = new String[capacity];
            n = capacity;

        }

        //出队
        public String dequeue(){

            if (head == tail){
                return "队空";
            }
            String value = items[head];
            head = (head + 1) % n;

            return value;
        }

        //入队
        public boolean enqueue(String val){

            if ((tail + 1) % n == head){
                return false;
            }
            items[tail] = val;
            tail = (tail + 1) % n;
            return true;
        }

        //打印
        public void printAll(){
            if (n == 0){
                return ;
            }
            for (int i = head;i % n != tail;i = (i + 1) % n){
                System.out.print(items[i] + "    ");
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        CircularArrayQueue caq = new CircularArrayQueue(10);
        caq.enqueue("a");
        caq.enqueue("b");
        caq.enqueue("c");
        caq.enqueue("d");
        caq.enqueue("e");
        caq.enqueue("f");
        caq.printAll();

        System.out.println("出列的值：" + caq.dequeue());

        caq.enqueue("g");
        caq.printAll();
        caq.enqueue("h");
        caq.enqueue("i");
        caq.enqueue("j");
        //循环队列会浪费一个 空间 容量为10的数组只能实际保存9个
        System.out.println(caq.enqueue("k"));
        caq.printAll();

        System.out.println(caq.dequeue());
        System.out.println(caq.enqueue("l"));
        caq.printAll();


    }

}
