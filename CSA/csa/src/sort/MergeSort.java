package sort;

/**
 * @author lukew
 * @create 2024-02-23 14:41
 * 归并排序
 */
public class MergeSort {


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[]{3,5,7,4,2,1,6};
        mergeSort.mergeSort(arr,0,arr.length-1);
        for (int i : arr){
            System.out.println(i);
        }
    }
    public void mergeSort(int[] arr, int p, int r){

        if (p >= r){
            return;
        }
        //找到分区节点
        int q = p + (r-p) / 2;

        mergeSort(arr,p,q);
        mergeSort(arr,q+1,r);

        //合并操作
        merge(arr,p,q,r);

    }

    public void merge(int[] arr, int p, int q, int r){

        int i = p;
        int j = q+1;
        int k = 0;

        //临时空间
        int[] temp = new int[r - p + 1];
        while(i<=q && j<=r){
            if (arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        //还有剩下的子数组
        int start = i;
        int end = q;

        if (j<=r){
            start = j;
            end = r;
        }

        //将剩下的子数组拷贝到temp中
        while(start <= end){
            temp[k++] = arr[start++];
        }

        //将temp中的数组拷贝会arr
        for (i = 0; i <= r-p; i++){
            arr[p+i] = temp[i];
        }


    }
}
