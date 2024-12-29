package try_again.array.binarysearch;

/**
 * @author lukew
 * @create 2024-05-08 9:07
 * LCR 172.统计目标成绩的出现
 */
public class CountTarget {

    public int countTarget(int[] scores, int target){

        //使用查找左右边界 然后获取长度即可
        int leftIndex = leftBound(scores,target);
        if (leftIndex == -1){
            return 0;
        }
        int rightIndex = rightBound(scores, target);

        return rightIndex - leftIndex + 1;


    }

    public int leftBound(int[] scores, int target){
        int left = 0;
        int right = scores.length - 1;
        while(left <= right){
            int mid = left + (right -  left) / 2;
            if (scores[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }
        if (left >= scores.length || scores[left] != target){
            return -1;
        }

        return left;

    }

    public int rightBound(int[] scores, int target){

        int left = 0;
        int right = scores.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (scores[mid] <= target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        if (right < 0 || scores[right] != target){
            return -1;
        }

        return right;

    }
}
