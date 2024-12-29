package util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * @author lukew
 * @create 2024-06-05 13:35
 */
public class AESExample {


    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 16;

    public static void main(String[] args) {

        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());

    }


    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(LENGTH);

        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(randomIndex));
        }

        return sb.toString();
    }



}
