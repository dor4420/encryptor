package iaf.ofek;

import java.io.IOException;
import java.util.Scanner;

public class PromptManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static CRYPTO_CHOICE promptEncryptionChoice() {
        System.out.println("Please choose your mode, 1 - Encryption, 2 - Decryption, 3 - Exit");
        int choice = scanner.nextInt();
        return switch (choice) {
            case 2 -> CRYPTO_CHOICE.DECRYPT;
            case 3 -> CRYPTO_CHOICE.EXIT;
            default -> CRYPTO_CHOICE.ENCRYPT;
        };
    }

    public static FileHelper promptGetFile() throws RuntimeException {
        System.out.println("Please input a your file path");
        String path = scanner.next();

        FileHelper fileHelper = new FileHelper(path);
        if (!fileHelper.isValid()) {
            throw new RuntimeException("Path is either not a file or cannot be accessed!");
        }
        return fileHelper;
    }

    public static void promptEncryption(FileHelper fileHelper) {
        System.out.println("Encrypting " + fileHelper.getFile().getName());
        Encryptor encryptor = new Encryptor(fileHelper);
        try {
            encryptor.encrypt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void promptDecryption(FileHelper fileHelper, byte key) {
        System.out.println("Decrypting " + fileHelper.getFile().getName());
        Encryptor decryptor = new Encryptor(fileHelper);
        try {
            decryptor.decrypt(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte promptInputKey() {
        System.out.println("Please input your key");
        return (byte) scanner.nextInt();
    }

    public static void promptExit() {
        System.out.println("Exiting...");
        System.exit(0);
    }
}
