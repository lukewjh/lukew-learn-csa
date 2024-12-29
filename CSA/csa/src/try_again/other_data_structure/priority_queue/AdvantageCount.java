package try_again.other_data_structure.priority_queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author lukew
 * @create 2024-10-25 9:10
 * 870.优势洗牌
 */
public class AdvantageCount {

    public int[] advantageCount(int[] nums1, int[] nums2){

        int n = nums1.length;
        //nums2降序排序
        PriorityQueue<int[]> maxpq = new PriorityQueue<>((int[] pair1, int[] pair2) -> {
            return pair2[1] - pair1[1];
        });

        for(int i = 0; i < n; i++){
            maxpq.offer(new int[]{i, nums2[i]});
        }

        //对nums1升序排序
        Arrays.sort(nums1);

        int left = 0, right = n - 1;
        int[] res = new int[n];

        while(!maxpq.isEmpty()){
            int[] pair = maxpq.poll();
            int i = pair[0], maxVal = pair[1];
            if(maxVal < nums1[right]){
                res[i] = nums1[right];
                right--;
            }else{
                res[i] = nums1[left];
                left++;
            }
        }

        return res;

    }
}
