package try_again.array;

/**
 * @author lukew
 * @create 2024-04-12 13:33
 * 360.有序转化数组
 */
public class SortedTransformedArray {

    public int[] sortedTransformedArray(int[] nums,int a,int b,int c){


        //双指针，相向而行 逼近对称轴
        int i = 0,j = nums.length - 1;

        //用a判断ax^2+bx+c的开口朝向
        //如果开口朝上，越靠近对称轴函数值越小
        //如果开口朝下，越靠近对称轴函数值越大
        //由此来决定p是从后向前还是从前向后 (从大到小排序)
        int p = a > 0 ? nums.length - 1:0;
        int[] res = new int[nums.length];

        while(i <= j){
            int v1 = a*nums[i]*nums[i] + b*nums[i] + c;
            int v2 = a*nums[j]*nums[j] + b*nums[j] + c;

            if (a > 0){

                if (v1 > v2){
                    res[p--] = v1;
                    i++;
                }else{
                    res[p--] = v2;
                    j--;
                }

            }else{
                if (v1 > v2){
                    res[p++] = v2;
                    j--;
                }else{
                    res[p++] = v1;
                    i++;
                }
            }
        }
        return res;

    }
}
