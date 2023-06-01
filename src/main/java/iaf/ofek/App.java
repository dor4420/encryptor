package iaf.ofek;

public class App {
    public static void main(String[] args) {
        Logo.printLogo();
        System.out.println("Welcome to Encryptor");

        CRYPTO_CHOICE choice = PromptManager.promptEncryptionChoice();

        FileHelper fileHelper = PromptManager.promptGetFile();

        switch (choice) {
            case EXIT -> PromptManager.promptExit();

            case ENCRYPT -> PromptManager.promptEncryption(fileHelper);

            case DECRYPT -> {
                byte key = PromptManager.promptInputKey();
                PromptManager.promptDecryption(fileHelper, key);
            }
        }

    }
}
