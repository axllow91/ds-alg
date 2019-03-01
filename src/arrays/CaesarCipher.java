package arrays;

public class CaesarCipher {
    protected char[] encoder = new char[26]; // encryption array
    protected char[] decoder = new char[26]; // decryption array

    public CaesarCipher(int rotation) {
        for(int k = 0; k < 26; k++) {
            encoder[k] = (char) ('A' + (k + rotation) % 26);
            decoder[k] = (char) ('A' + (k - rotation) % 26);
        }
    }

    /**Returns String representing encrypted message**/
    public String encrypt(String message) {
        return transform(message, encoder);  // use encoder array
    }

    /**Returns decrypted message given encrypted secret**/
    public String decrypt(String secret) {
        return transform(secret, decoder);
    }

    /**Returns transformation of original String using given code**/
    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();

        for(int k = 0; k < msg.length; k++)
            if(Character.isUpperCase(msg[k])) {
                int j = msg[k] - 'A';
                msg[k] = code[j];
            }
        return new String(msg);
    }

    public static void main(String[] args) {
        CaesarCipher cc = new CaesarCipher(5);
        System.out.println("Encryption Code: " + new String(cc.encoder));
        System.out.println("Decryption Code: " + new String(cc.decoder));

        String message = "THE EAGLE IS IN PLAY; MET ME AT ZORILE";
        String coded = cc.encrypt(message);
        System.out.println("Secret: " + coded);
        String encoded = cc.decrypt(coded);
        System.out.println("Message: " + encoded);
    }
}
