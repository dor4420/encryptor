import iaf.ofek.Encryptor;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CaesarAlgoTest {

    private static final String DECRYPTED_FILE_PATH = "output/text.txt";
    private static final String ENCRYPTED_FILE_PATH = "output/text.txt.encrypted";
    private static final byte KEY = 87;
    @Test
    public void testEncrypt() {
        Encryptor encryptor = new Encryptor(DECRYPTED_FILE_PATH, KEY);
        try {
            encryptor.encrypt();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDecrypt() {
        Encryptor decryptor = new Encryptor(ENCRYPTED_FILE_PATH, KEY);
        try {
            decryptor.decrypt(KEY);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void byteTest() {
        byte one = -85;
        byte two = 87;

        System.out.println((byte) (one - two));
    }
}
