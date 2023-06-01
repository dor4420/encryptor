package iaf.ofek;

import java.io.*;

public class FileHelper {

    private final File file;

    private static final String dotEncryptedRegex = "(?i)\\.encrypted$";
    String regex = "(?i)\\.(\\w+)$"; // Matches the file extension / Yes I stole it from GPT
    String replacement = "_decrypted.$1"; // Adds _decrypted before the file extension / Yes I stole it from GPT


    public FileHelper(String path) {
        this.file = new File(path);
    }

    public boolean isValid() {
        return file.isFile() && file.canRead();
    }

    public File getFile() {
        return file;
    }

    public void createFile(byte[] data) throws IOException {

        try {
            file.createNewFile();
            this.writeToFile(data);
        } catch (IOException e) {
            throw new IOException("Failed to create file");
        }
    }

    public void writeToFile(byte[] data) {
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] readFromFile(){

        byte[] data;

        try(FileInputStream inputStream = new FileInputStream(file)) {
            data = inputStream.readAllBytes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public String getDecryptedName() {
        String encryptedName = file.getName();
        String dotEncryptedRemoved = encryptedName.replaceAll(dotEncryptedRegex, "");
        return dotEncryptedRemoved.replaceAll(regex, replacement);
    }
}
