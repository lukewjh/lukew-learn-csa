package sort;

/**
 * @author lukew
 * @create 2024-02-27 9:07
 * 桶排序
 */
public class BucketSort {

    public static void main(String[] args) {
        BucketSort bs = new BucketSort();
        int[] arr = new int[]{5,1,1,5,2,6,3,8,4,5,9,4,5,1,7,5,4,5,6,1,7,8,9,1,1,11,22,35,85};
        bs.buketSort(arr,arr.length);

        for (int i : arr){
            System.out.println(i);
        }
    }


    public void buketSort(int[] arr,int bucketSize){

        if (arr.length < 2){
            return;
        }

        //找到数组中的最大值和最小值
        int minValue = arr[0];
        int maxValue = arr[1];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < minValue){
                minValue = arr[i];
            }
            if (arr[i] > maxValue){
                maxValue = arr[i];
            }
        }

        //桶数量：数组中最大值-最小值/数组长度 + 1
        int bucketCount = (maxValue - minValue)/bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArray = new int[bucketCount];

        //将数组中的值分配到各个桶中
        for (int i = 0; i < arr.length;i++){
            int bucketIndex = (arr[i] - minValue)/bucketSize;
            if (indexArray[bucketIndex] == buckets[bucketIndex].length){
                ensureCapacity(buckets,bucketIndex);
            }
            buckets[bucketIndex][indexArray[bucketIndex]++] = arr[i];
        }

        //对每个桶内进行快排
        int k = 0;
        for(int i = 0;i < buckets.length;i++){
            if (indexArray[i] == 0){
                continue;
            }
            quickSort(buckets[i],0,indexArray[i] - 1);
            for (int j = 0;j<indexArray[i];j++){
                arr[k++] = buckets[i][j];
            }
        }

    }

    //桶中数组扩容
    public void ensureCapacity(int[][] buckets,int bucketIndex){
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0;j < tempArr.length;j++){
            newArr[j] = tempArr[j];
        }

        buckets[bucketIndex] = newArr;

    }

    public void quickSort(int[] arr,int p, int r){
        if (p >= r) return;


        int q = partition(arr,p,r);
        quickSort(arr, p, q-1);
        quickSort(arr, q+1, r);
    }

    public int partition(int[] arr,int p, int r){

        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, r);
        return i;

    }

    /**
     * 交换
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
