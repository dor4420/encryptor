package iaf.ofek;

public class DataManipulator {
    public static byte[] encrypt(byte[] message) {
        byte[] encryptedMessage = new byte[message.length];

        byte key = KeyGenerator.getKey();

        for (int i = 0; i < message.length; i++) {
            encryptedMessage[i] = CaesarAlgo.encrypt(message[i], key);
        }

        return encryptedMessage;
    }

    public static byte[] encrypt(byte[] message, byte key) {
        byte[] encryptedMessage = new byte[message.length];

        System.out.println("Started Encrypting");
        for (int i = 0; i < message.length; i++) {
            encryptedMessage[i] = CaesarAlgo.encrypt(message[i], key);
        }

        return encryptedMessage;
    }

    public static byte[] decrypt(byte[] encryptedMessage, byte key) {
        byte[] decryptedMessage = new byte[encryptedMessage.length];

        for (int i = 0; i < encryptedMessage.length; i++) {
            decryptedMessage[i] = CaesarAlgo.decrypt(encryptedMessage[i], key);
        }

        return decryptedMessage;
    }

}
