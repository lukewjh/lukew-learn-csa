package sort;

/**
 * @author lukew
 * @create 2024-05-13 15:11
 * 归并排序
 */
public class MergeSort2 {


    public void sort(int[] arr, int p, int r){


        if (p >= r){
            return;
        }
        int mid = p + (r - p) / 2;

        sort(arr, p, mid);
        sort(arr, mid + 1, r);

        //合并
        merge(arr,p,mid,r);
    }

    public void merge(int[] arr, int p, int mid, int r){

        int i = p;
        int j = mid + 1;
        int k = 0;

        int[] temp = new int[r - p + 1];
        while(i <= mid && j <= r){
            if (arr[i] <= arr[j]){
                temp[k++] = arr[i];
            }else{
                temp[k++] = arr[j];
            }

        }

        //剩下的子数组合并
        int start = i;
        int end = mid;

        if (j <= r){
            start = j;
            end = r;
        }

        while(start <= end){
            temp[k++] = arr[start++];
        }

        //将temp中的数据拷贝回arr中
        for(i = 0; i <= r - p; i++){
            arr[p + i] = temp[i];
        }

    }
}
