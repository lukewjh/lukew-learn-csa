package try_again.array;

/**
 * @author lukew
 * @create 2024-04-12 10:04
 * 回文串判断
 */
public class IsPalindrome {

    boolean isPalindrome(String s){
        int left = 0,right = s.length() - 1;
        while(left < right){

            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }


}
