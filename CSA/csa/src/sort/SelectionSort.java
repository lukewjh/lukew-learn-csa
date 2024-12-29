package sort;

/**
 * @author lukew
 * @create 2024-02-22 14:42
 * 选择排序
 */
public class SelectionSort {


    public void selectionSort(int[] arr){

        int n = arr.length;

        for (int i = 0; i < n; i++){
            int minIndex = i;

            for (int j = i+1; j < n; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            //将找到的最小元素与当前位置互换
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }

    }
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {55,66,11,22,55,77};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(arr);
        SelectionSort.printArray(arr);
    }



}
