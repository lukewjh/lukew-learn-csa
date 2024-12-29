package try_again.array;

/**
 * @author lukew
 * @create 2024-04-12 10:54
 * 88.合并两个有序数组
 */
public class MergeSortedArray {

    public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n){
        //使用从后向前的双指针
        int i = m - 1,j = n - 1;
        //nums1的数组指针(从后向前)
        int p = nums1.length - 1;

        while(i >= 0 && j >= 0){
            if (nums1[i] > nums2[j]){
                nums1[p] = nums1[i];
                i--;
            }else{
                nums1[p] = nums2[j];
                j--;
            }
            p--;
        }

        //将剩余的元素添加  只需要考虑nums2是否有剩就行 因为是在nums1中添加的
        while(j >= 0){
            nums1[p] = nums2[j];
            j--;
            p--;
        }
    }
}
