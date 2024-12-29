package try_again.array;

/**
 * @author lukew
 * @create 2024-04-12 10:11
 * 5.最长回文子串
 */
public class LongestPalindrome {

    //在s中寻找以s[l]和s[r]为中心的最长回文串
    String palindrome(String s,int l, int r){
        while(l >= 0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        return s.substring(l+1,r);
    }

    String longestPalindrome(String s){
        String res = "";
        for(int i = 0; i < s.length(); i++){
            //奇数位的
            String s1 = palindrome(s,i,i);
            //偶数位的
            String s2 = palindrome(s,i,i+1);

            //比较
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }
}
