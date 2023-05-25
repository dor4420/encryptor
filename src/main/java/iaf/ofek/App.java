package iaf.ofek;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Logo.printLogo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Encryptor");
        CRYPTO_CHOICE choice;
        while (true) {
            System.out.println("Please choose your mode\nEnter 0 for Encryption, 1 for Decryption");
            choice = CRYPTO_CHOICE.values()[scanner.nextInt()];

            if (choice == CRYPTO_CHOICE.ENCRYPT) {
                System.out.println("Encryption!");
                break;
            } else if (choice == CRYPTO_CHOICE.DECRYPT) {
                System.out.println("Decryption!");
                break;
            } else {
                System.out.println("Are you retarded?");
                System.out.println("Starting over...");
            }
        }

        System.out.println("Please input a your file path");
        String path = scanner.next();

        File file = new File(path);

        if (!file.canRead() || !file.isFile() || file.isDirectory()) {
            System.out.println("File doesn't exists, isn't readable or a folder!!!");
            return;
        }

        String fileName = file.getName();

        if (choice == CRYPTO_CHOICE.ENCRYPT) {
            System.out.println("Encrypting " + fileName);
        } else {
            System.out.println("Decrypting " + fileName);
        }
    }
}
