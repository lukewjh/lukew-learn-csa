package sort;

/**
 * @author lukew
 * @create 2024-02-22 13:44
 * 插入排序
 */
public class InsertionSort {


    // 2   1 4 3 5
    // 2   2 4 3 5
    // 1 2   4 3 5
    // 1 2 4   3 5
    // 1 2 4   4 5
    // 1 2 3 4   5

    public void insertionSort(int[] arr,int n){
        if (n <= 1){
            return;
        }

        for (int i = 1; i < n; i++){
            int value = arr[i];
            int j = i - 1;
            for(;j >= 0; j--){
                if (arr[j] > value){
                    arr[j + 1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j + 1] = value;
        }

    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,1,4,5,3};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(arr,arr.length);

        for (int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }


}
