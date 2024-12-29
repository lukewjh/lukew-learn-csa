package stack;

/**
 * @author lukew
 * @create 2024-02-20 14:55
 *
 * 链式栈
 */
public class LinkedStackMain {

    //结点类
    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }


    static class LinkedStack{

        //最大容量
        int maxSize = 0;

        //栈顶结点
        Node top;

        //判断栈是否为空
        public boolean isEmpty(){
            return top == null;
        }

        //入栈
        public void push(int val){


            Node newNode = new Node(val,top);
            top = newNode;

            maxSize ++;
        }

        //出栈
        public int pop(){
            if (top == null)  throw new RuntimeException("栈空");
            int val = top.val;
            //将top 设为下一个结点
            top = top.next;
            return val;
        }

        //打印栈
        public void printAll(){
            System.out.println("打印栈所有元素");
            Node cur = top;
            while( cur != null ){
                System.out.print(cur.val + "    ");
                cur = cur.next;
            }
            System.out.println();
        }

        //查看栈顶元素
        public int peek(){
            if (top == null) throw new RuntimeException("栈空");
            return top.val;
        }

    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();

        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.push(5);

        linkedStack.printAll();

        System.out.println("栈顶元素："+linkedStack.peek());
        System.out.println("出栈元素：" + linkedStack.pop());

        linkedStack.printAll();

        linkedStack.push(6);
        linkedStack.printAll();


    }

}
