package search;

/**
 * @author lukew
 * @create 2024-02-28 11:05
 * 二分查找的变体
 */
public class BSearchVariant {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,3,3,3,4,5,6,7,8,9};
        BSearchVariant bSearchVariant = new BSearchVariant();
        System.out.println(bSearchVariant.bSearchVariant1(arr, 2));
    }


    //查找第一个值等于给定值的元素
    public int bSearchVariant1(int[] arr, int val){

        //初始化 指针
        int low = 0;
        int high = arr.length-1;



        while(low <= high){
            int mid = low + (high - low)/2;
            if (arr[mid] > val){
                high = mid - 1;
            }else if (arr[mid] < val){
                low = mid + 1;
            }else{
                if (mid == 0 || arr[mid-1] != val) {
                    return mid;
                }else{
                    high = mid - 1;
                }
            }
        }

        return -1;

    }
}
