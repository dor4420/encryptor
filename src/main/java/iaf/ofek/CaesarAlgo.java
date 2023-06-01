package iaf.ofek;

public class CaesarAlgo {

    public static byte encrypt(byte data, byte key) {
        return (byte) (data + key);
    }

    public static byte decrypt(byte data, byte key) {
        return (byte) (data - key);
    }
}
