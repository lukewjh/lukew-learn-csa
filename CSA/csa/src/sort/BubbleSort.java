package sort;

/**
 * @author lukew
 * @create 2024-02-22 11:26
 */
public class BubbleSort {

    /**
     * 普通的冒泡排序
     * @param arr
     */
    public void bubbleSort(int[] arr){

        int n = arr.length;

        for(int i = 0; i < n; i++){

            boolean flag = false;
            for (int j = 0; j < n-i-1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }

    }

    /**
     * 改进后的冒泡排序
     * @param arr
     * 记录最后一次交换数据的 边界 下次循环则不需要到此边界
     */
    public void bubbleSort2(int[] arr){

        int n = arr.length;
        if (n <= 1){
            return ;
        }

        //最后一次交换的位置
        int lastExchange = 0;
        //无序数据的边界 每次比较到这 即可退出
        int sortBorder = n - 1;
        for (int i = 0;  i<n;i++){
            boolean flag = false;

            for (int j = 0; j < sortBorder; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    lastExchange = j;
                    flag = true;
                }
            }
            sortBorder = lastExchange;

            if (!flag){
                break;
            }

        }





    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,2,4,1};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort2(arr);
        for (int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

}
