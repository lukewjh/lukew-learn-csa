package try_again.other_data_structure.hash;

/**
 * @author lukew
 * @create 2024-09-30 9:13
 * 389.找不同
 */
public class FindTheDifference {

    //使用位运算

    public char findTheDifference(String s, String t){
        int res = 0;
        //a ^ a = 0;
        //0 ^ a = a;
        for(char c : s.toCharArray()){
            res = res ^ c;
        }

        for(char d : t.toCharArray()){
            res = res ^ d;
        }

        return (char)res;
    }
}