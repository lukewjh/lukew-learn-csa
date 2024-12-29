package try_again.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-05-09 13:34
 * 870.优势洗牌
 */
public class AdvantageCount {

    public int[] advantageCount(int[] nums1, int[] nums2){

        int n = nums1.length;

        //大根堆 记录nums2 及其对应的索引值
        //对nums2按照值的降序排序 同时记录 索引
        PriorityQueue<int[]> maxpq = new PriorityQueue<>((int[] pair1, int[] pair2) -> {
            return pair2[1] - pair1[1];
        });

        for(int i = 0; i < nums2.length; i++){
            maxpq.offer(new int[]{i, nums2[i]});
        }

        //将nums1升序排序
        Arrays.sort(nums1);

        //现在nums1中的left是最小值  right是最大值
        int left = 0;
        int right = n - 1;

        int[] res = new int[n];

        while(!maxpq.isEmpty()){

            //取出nums中的最大值
            int[] pair = maxpq.poll();

            int i = pair[0];
            int maxval = pair[1];

            if (maxval < nums1[left]){
                res[i] = nums1[right];
                right--;
            }else{
                res[i] = nums1[right];
                left++;
            }


        }
        return res;



    }
}
