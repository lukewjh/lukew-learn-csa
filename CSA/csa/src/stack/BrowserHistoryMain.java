package stack;

/**
 * 浏览器前进后退功能实现
 * 链式栈实现
 * @author lukew
 * @create 2024-02-20 15:23
 */
public class BrowserHistoryMain {

    //结点类
    static class Node{
        int val;
        Node next;


        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    //链式栈
    static class LinkedStack{

        Node top;

        //入栈
        public void push(int val){
            Node newNode = new Node(val,top);
            top = newNode;
        }

        //出栈
        public int pop(){
            if (top == null)  throw new RuntimeException("栈空");
            int value = top.val;
            top = top.next;

            return value;
        }

        //查看栈
        public void printAll(){
            Node cur = top;
            while( cur != null ){
                System.out.print(cur.val + "  ");
                cur = cur.next;
            }
            System.out.println();
        }

    }


    static class BrowserAction{

        //栈1
        private LinkedStack linkedStackX;

        //栈2
        private LinkedStack linkedStackY;


        public BrowserAction() {
            this.linkedStackX = new LinkedStack();
            this.linkedStackY = new LinkedStack();
        }

        //访问 入栈1
        public void visit(int val){
            linkedStackX.push(val);
        }

        //后退 栈1出 入栈2
        public void drawBack(){
            int xPopVal = linkedStackX.pop();
            linkedStackY.push(xPopVal);
        }

        //前进
        public void foreward(){
            int yPopVal = linkedStackY.pop();
            linkedStackX.push(yPopVal);
        }

        //查看前进或者后退历史
        public void print(){
            System.out.println("前进历史");
            linkedStackX.printAll();

            System.out.println("后退历史");
            linkedStackY.printAll();
        }






    }

    public static void main(String[] args) {
        BrowserAction browserAction = new BrowserAction();
        browserAction.visit(1);
        browserAction.visit(2);
        browserAction.visit(3);

        //后退一个
        browserAction.drawBack();

        //查看
        browserAction.print();

    }


}
