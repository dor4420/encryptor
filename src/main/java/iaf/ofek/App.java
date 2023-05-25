package iaf.ofek;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Logo.printLogo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Encryptor");
        while(true) {
            System.out.println("Please choose your mode\nEnter 1 for Encryption, 2 for Decryption");
            int choice = scanner.nextInt();

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

    }
}
