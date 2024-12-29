package try_again.array;

/**
 * @author lukew
 * @create 2024-04-12 9:42
 * 344.反转字符串
 */
public class reverseArray {

    void reverseString(char[] s){
        //双指针交换
        int left = 0,right = s.length - 1;
        while(left < right){

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;

        }
    }
}
