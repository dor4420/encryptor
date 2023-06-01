package iaf.ofek;

import java.io.IOException;
import java.nio.file.Path;

public class Encryptor {

    private final FileHelper fileHelper;
    private final byte key;

    public Encryptor(String filePath, byte key) {
        this.fileHelper = new FileHelper(filePath);
        this.key = key;
    }

    public Encryptor(FileHelper fileHelper) {
        this.fileHelper = fileHelper;
        this.key = 0;
    }


    public void encrypt() throws IOException {
        byte[] data = fileHelper.readFromFile();
        byte[] encryptedData;

        encryptedData = ((key != 0) ? DataManipulator.encrypt(data, key) : DataManipulator.encrypt(data));

        String encryptedFilePath = fileHelper.getFile().getPath() + ".encrypted";
        FileHelper encryptedFile = new FileHelper(encryptedFilePath);

        encryptedFile.createFile(encryptedData);
    }

    public void decrypt(byte key) throws IOException {
        byte[] data = fileHelper.readFromFile();
        byte[] decryptedData = DataManipulator.decrypt(data, key);

        Path filePath = fileHelper.getFile().toPath();
        String decryptedFileDirPath = filePath.getParent().toString();
        String fileName = fileHelper.getDecryptedName();
        String decryptedFilePath = decryptedFileDirPath + "/" + fileName;

        FileHelper decryptedFile = new FileHelper(decryptedFilePath);

        decryptedFile.createFile(decryptedData);
    }
}
