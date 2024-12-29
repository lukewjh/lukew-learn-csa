package search;

/**
 * @author lukew
 * @create 2024-02-27 15:01
 * 二分查找
 */
public class BSearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        BSearch bs = new BSearch();
        System.out.println("遍历二分查找的位置在："+bs.bSearch(arr, 1) + "+1位");


        int[] arr2 = new int[]{1,2,3,4,5,6,7,8,9};
        BSearch bs2 = new BSearch();
        System.out.println("递归二分要查找的位置在："+bs2.bSearch(arr2, 9) + "+1位");
    }


    public int bSearch(int[] arr,int val){
        //初始化low、high、mid
        int low = 0;
        int high = arr.length - 1;



        while(low <= high){
            //注意：求mid时为了避免相加时数据溢出 从(low + high)/2  改写为  low + (high - low)/2
            int mid = low + (high - low)/2;
            if (arr[mid] == val) return mid;
            if (arr[mid] < val){
                low = mid + 1;
            }else if (arr[mid] > val){
                high = mid - 1;
            }

        }

        return -1;

    }

    //递归的实现方式
    public int bSearchInternally(int[] arr, int low,int high, int val){

        if (low > high) {
            return -1;
        }

        int mid = low + (high - low)/2;
        if(arr[mid] == val){
            return mid;
        }else if (arr[mid] < val){
            bSearchInternally(arr,mid + 1,high,val);
        }else{
            bSearchInternally(arr, low, mid - 1, val);
        }

        return -1;


    }

}
