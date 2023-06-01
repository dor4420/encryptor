package iaf.ofek;

import java.util.Random;

public class KeyGenerator {
    public static byte getKey() {
        byte key = (byte) new Random().nextInt();
        System.out.println("Generated Key:" + key);
        return key;
    }
}
