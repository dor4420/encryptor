package iaf.ofek;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Logo.printLogo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Encryptor");
        int choice;
        while(true) {
            System.out.println("Please choose your mode\nEnter 1 for Encryption, 2 for Decryption");
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Encryption!");
                break;
            } else if (choice == 2) {
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

        if (choice == 1) {
            System.out.println("Encrypting " + fileName);
        } else {
            System.out.println("Decrypting " + fileName);
        }
    }
}
