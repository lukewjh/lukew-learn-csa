package heap;

/**
 * @author lukew
 * @create 2024-03-07 14:35
 * 堆
 */
public class HeapMain {

    //创建一个从下标1开始的堆数组
    static class Heap{
        //存储堆结构是一个数组  因为堆一定是一个完全二叉树，所以用数组来存取是省内存的
        int[] heap;
        int size;
        int capacity;
        //初始化堆


        public Heap(int capacity) {
            //已用大小
            this.size = 1;
            //堆大小的初始化
            this.heap = new int[capacity];
            //堆的容量
            this.capacity = capacity;
        }

        //获取某个节点的父节点下标
        public int parent(int i){
            return i / 2;
        }
        //获取某个节点的左子节点下标
        public int leftChild(int i){
            return i * 2;
        }
        //获取某个节点的右子节点下标
        public int rightChild(int i){
            return (i * 2) + 1;
        }

        //两个下标的值互换
        public void swap(int i,int j){
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        //对某个节点向上堆化
        public void heapifyUp(int index){
            int currentIndex = index;
            while(currentIndex > 1 && heap[currentIndex] > heap[parent(currentIndex)]){
                swap(currentIndex,parent(currentIndex));
                currentIndex = parent(currentIndex);
            }
        }

        //对某个节点向下堆化
        public void heapifyDown(int index){
            int maxIndex = index;
            int left = leftChild(index);
            int right = rightChild(index);

            //如果是左节点比当前节点大，则交换下标
            if (left < size && heap[left] > heap[maxIndex]){
                maxIndex = left;
            }
            if (right < size && heap[right] > heap[maxIndex]){
                maxIndex = right;
            }

            //如果进行了下标改变，则证明是需要交换元素了
            if (maxIndex != index){
                swap(maxIndex,index);
                //递归向下继续堆化
                heapifyDown(maxIndex);
            }

        }

        //向堆中插入元素
        public void insert(int data){
            if (size == capacity){
                System.out.println("该堆已满");
                return;
            }
            //将新元素先放入最后一个节点，再向上堆化
            heap[size] = data;
            size ++;
            heapifyUp(size - 1);

        }

        //移除堆顶 返回已移除的节点
        public int extractMax(){

            if (size <= 0){
                System.out.println("堆为空");
                return -1;
            }
            //将堆顶用最后一个节点替换，删除最后一个节点，并且向下堆化
            int root = heap[1];

            heap[1] = heap[size - 1];
            size --;
            heapifyDown(1);
            return root;
        }

        //打印堆结构
        public void printHeap(){
            for (int i = 1; i < size; i++){
                System.out.print(heap[i] + "    ");
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(9);
        heap.insert(10);
        heap.insert(11);
        heap.insert(12);
        heap.insert(12);
        heap.insert(16);
        heap.insert(7);
        heap.insert(2);
        heap.insert(3);

        System.out.println("原堆");
        heap.printHeap();

        //取出堆顶
        System.out.println("取出堆顶"+heap.extractMax());


        System.out.println("新堆");
        heap.printHeap();



    }

}
