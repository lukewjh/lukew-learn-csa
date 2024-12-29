package try_again.array;

/**
 * @author lukew
 * @create 2024-04-17 13:40
 * 238.除自身以外数组的乘积
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums){

        int n = nums.length;

        //前缀积
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i - 1] * nums[i];
        }

        //后缀积
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for(int i = n - 2;i >= 0; i--){
            suffix[i] = suffix[i + 1] * nums[i];
        }

        //结果
        int[] res = new int[n];
        res[0] = suffix[1];
        res[n - 1] = prefix[n - 2];
        for(int i = 1; i < n - 1; i++){
            res[i] = prefix[i - 1] * suffix[i + 1];
        }
        return res;

    }
}
