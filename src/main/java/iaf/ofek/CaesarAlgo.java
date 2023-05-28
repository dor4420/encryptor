package iaf.ofek;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class CaesarAlgo {

    private static final byte HIGHEST_KEY_ALLOWED = 127;
    private static final byte LOWEST_KEY_ALLOWED = 31;

    private static final byte KEY_RANGE = HIGHEST_KEY_ALLOWED - LOWEST_KEY_ALLOWED;

    public static String encrypt(String message, boolean isTest) {
        byte[] messageInBytes = message.getBytes();
        byte[] encryptedData = new byte[messageInBytes.length];

        byte key = (byte) new Random().nextInt(KEY_RANGE);

        if (isTest) {
            key = (byte) 87;
        }

        System.out.println("Key:" + key);

        System.out.println("Encrypting...");
        for (int i = 0; i < messageInBytes.length; i++) {
            int sum = messageInBytes[i] + key;
            if (sum >= HIGHEST_KEY_ALLOWED) {
                sum -= KEY_RANGE; //127 = HIGHEST DEC NUMBER ALLOWED  31 = LOWEST ALLOWED
            }
            encryptedData[i] = (byte) sum;
        }
        return new String(encryptedData, StandardCharsets.US_ASCII);
    }

    public static String decrypt(String message, byte key) {
        byte[] messageInBytes = message.getBytes();
        byte[] decryptedData = new byte[messageInBytes.length];
        System.out.println("Decrypting...");
        for (int i = 0; i < messageInBytes.length; i++) {
            int sum = messageInBytes[i] - key;
            if (sum <= LOWEST_KEY_ALLOWED) {
                sum += KEY_RANGE;
            }
            decryptedData[i] = (byte) sum;
        }
        return new String(decryptedData, StandardCharsets.US_ASCII);
    }
}
