package stack;

/**
 * @author lukew
 * @create 2024-02-20 14:04
 * 栈的实现
 */
public class ArrayStackMain {


    //顺序栈：使用数组实现的栈
    static class ArrayStack{
        //最大容量
        private int maxSize;
        //栈顶指针
        private int top;
        //用于存储栈元素的数组
        private int[] stackArray;

        public ArrayStack(int maxSize) {
            this.maxSize = maxSize;
            //栈的初始化为 -1 表示空栈
            this.top = -1;
            this.stackArray = new int[maxSize];
        }

        //判断栈是否为空
        public boolean isEmpty(){
            return top == -1;
        }

        //判断栈是否已满
        public boolean isFull(){
            return top == maxSize - 1;
        }

        //入栈操作
        public void push(int val){
            if (isFull()){
                //自动扩容操作
                arrayStackIncrease();
//                throw new RuntimeException("栈已满");
            }
            top ++;
            stackArray[top] = val;
        }

        //出栈
        public int pop(){
            if (isEmpty()){
                throw new RuntimeException("栈为空");
            }
            int value = stackArray[top];
            top--;
            return value;
        }

        //查看栈顶元素
        public int peek(){
            if (isEmpty()){
                throw new RuntimeException("栈为空");
            }
            return stackArray[top];
        }

        //打印栈元素
        public void printAll(){
            if (isEmpty()){
                System.out.println("栈为空");
                return;
            }
            System.out.println("栈元素：");
            for (int i = 0;i <= top; i++){
                System.out.print(stackArray[i] + "    ");
            }
            System.out.println();
        }


        //扩容
        private void arrayStackIncrease(){
            //创建一个新的数组 是原来数组的两倍
            int[] newStackArray = new int[maxSize * 2];

            //将旧数组中的数据拷贝到新数组中
            for (int i = 0; i < maxSize; i++){
                newStackArray[i] = stackArray[i];
            }
            maxSize *= 2;
            stackArray = newStackArray;
        }


    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        stack.printAll();
        System.out.println("栈顶元素：" + stack.peek());
        System.out.println("出栈元素：" + stack.pop());

        stack.printAll();
        stack.push(7);
        stack.printAll();

        //再次自动扩容
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);

        stack.push(14);
        stack.printAll();
    }
}

