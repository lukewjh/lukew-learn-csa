package stringmatchalgorithm;

/**
 * @author lukew
 * @create 2024-03-12 8:58
 * BF bruteForceSearch 暴力字符串匹配法 时间复杂度是 O(m*n)
 */
public class BFMain {

    public static void main(String[] args) {
        String text = "Hello,World";
        String pattern = "World";

        System.out.println(bf(text, pattern));
    }


    public static int bf(String text,String pattern){
        int textLength = text.length();
        int patternLength = pattern.length();

        for (int i = 0; i <= textLength - patternLength; i++){

            int j;
            for (j = 0; j < patternLength; j++){
                if (text.charAt(i + j) != pattern.charAt(j)){
                    break;
                }
            }

            //如果相等则证明这个pattern在主串中全部都匹配
            if (j == patternLength){
                return i;
            }
        }
        return -1;

    }
}
