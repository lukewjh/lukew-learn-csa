package sort;

/**
 * @author lukew
 * @create 2024-02-26 11:21
 * 快排
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,5,4,2,1,};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr,0,arr.length-1);
        for (int i : arr){
            System.out.println(i);
        }
    }



    public void quickSort(int[] arr,int p,int r){

        if (p >= r) return;

        int q = partition(arr,p,r);
        quickSort(arr,p,q-1);
        quickSort(arr,q+1,r);

    }

    public int partition(int[] arr,int p, int r){

        int pivot = arr[r];
        int i = p;


        for (int j = p;j < r ;j++){
            if (arr[j] < pivot){
                if ( i == j ){
                    i++;
                }else{
                    int temp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        //最后再将pivot放中间当q
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;

        System.out.println("分区的i为："+i);

        //返回q的下标
        return i;


    }
}
