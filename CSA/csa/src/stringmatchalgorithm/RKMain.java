package stringmatchalgorithm;

/**
 * @author lukew
 * @create 2024-03-12 9:12
 * RK Rabin-Karp 字符串匹配算法 哈希比对
 */
public class RKMain {

    private static final long PRIME = 101;
    private static final long MODULO = 1_000_000_007;

    public static void main(String[] args) {
        String text = "Hello, World";
        String pattern = "World";

        int index = rabinKarpSearch(text, pattern);

        if (index != -1) {
            System.out.println("Pattern found at index: " + index);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }

    public static int rabinKarpSearch(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        long patternHash = calculateHash(pattern, patternLength);
        long textHash = calculateHash(text, patternLength);

        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == textHash && checkEquality(text, i, pattern)) {
                return i; // 找到匹配
            }

            if (i < textLength - patternLength) {
                textHash = recalculateHash(text, i, textHash, patternLength);
            }
        }

        return -1; // 未找到匹配
    }

    private static long calculateHash(String str, int length) {
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash = (hash * PRIME + str.charAt(i)) % MODULO;
        }
        return hash;
    }

    private static long recalculateHash(String str, int oldIndex, long oldHash, int patternLength) {
        long newHash = (oldHash - str.charAt(oldIndex) * pow(PRIME, patternLength - 1)) % MODULO;
        newHash = (newHash * PRIME + str.charAt(oldIndex + patternLength)) % MODULO;
        return (newHash + MODULO) % MODULO; // 处理负数情况
    }

    private static boolean checkEquality(String text, int startIndex, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(startIndex + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static long pow(long base, int exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MODULO;
            }
            base = (base * base) % MODULO;
            exponent /= 2;
        }
        return result;
    }
}
