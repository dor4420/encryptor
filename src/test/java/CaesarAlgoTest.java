import iaf.ofek.CaesarAlgo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CaesarAlgoTest {

    private static final String DECRYPTED_MESSAGE = "This is a medium size paragraph, let's encrypt it and see what happens";
    private static final String ENCRYPTED_MESSAGE = "K_`jw`jwXwd\\[`ldwj`q\\wgXiX^iXg_#wc\\k~jw\\eZipgkw`kwXe[wj\\\\wn_Xkw_Xgg\\ej";
    @Test
    public void testEncrypt() {
        String encryptedText = CaesarAlgo.encrypt(DECRYPTED_MESSAGE, true);

        // The expected result after encryption with key=3 is "Khoor"
//        String expected = "Khoor";

        System.out.println(encryptedText);
//        Assertions.assertEquals(expected, encryptedText);
    }

    @Test
    public void testDecrypt() {
        String decryptedText = CaesarAlgo.decrypt(ENCRYPTED_MESSAGE, (byte) 87);
        System.out.println(decryptedText);
        Assertions.assertEquals(DECRYPTED_MESSAGE, decryptedText);
    }
}
