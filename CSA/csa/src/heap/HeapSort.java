package heap;

/**
 * @author lukew
 * @create 2024-03-07 15:38
 */
public class HeapSort {

    public static void heapSort(int[] arr){
        int n = arr.length;

        //堆排序两步：1.建堆   2.排序

        //建堆
        //直接找到叶子节点的上一层最后一个节点来堆化，这层节点才是有左右子节点的节点（完全二叉树）
        for (int i = n/2 - 1;i >= 0; i--){
            heapify(arr,n,i);
        }

        //排序 原理是将堆顶取出来  大顶堆下的堆顶是最大的值
        //取出来的方式  将堆中最后一个元素 与堆顶交换  然后再把交换后的进行堆化
        for (int i = n - 1; i > 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新堆化
            heapify(arr,i,0);
        }




    }


    //堆化
    public static void heapify(int[] arr,int n,int i){

        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]){
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]){
            largest = right;
        }

        //如果最大值不是根节点，证明左右两子节点中有更大的值  做交换
        if (largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] =  temp;

            //继续递归找到更小的节点
            heapify(arr,n,largest);
        }
    }

    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "     ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {11,10,9,8,7,5,6,1};

        printArr(arr);

        System.out.println("堆排序后：");
        heapSort(arr);
        printArr(arr);
    }
}
