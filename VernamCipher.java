package cryptography;

import java.util.Scanner;

public class VernamCipher {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        String key = generateKey(message);
        VernamCipherEncryption ve = new VernamCipherEncryption(message, key);
        System.out.println(ve.encryption());
        System.out.println(ve.decryption());
    }
    private static String generateKey(String message) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            sb.append((char) (Math.random() * 26 + 'a'));
        }
        return sb.toString();
    }
}

class VernamCipherEncryption {
    private String message;
    private String key;

    VernamCipherEncryption(String message, String key) {
        this.message = message;
        this.key = key;
        if (message.length() != key.length()) {
            throw new IllegalArgumentException("Message and key should be of same length");
        }
    }

    StringBuilder cipherText = new StringBuilder();

    public String encryption() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char m = message.charAt(i);
            char k = key.charAt(i);
            char xor = (char) (m ^ k);
            sb.append(xor);
        }
        cipherText = sb;
        return sb.toString();
    }

    public String decryption() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            char k = key.charAt(i);
            char xor = (char) (c ^ k);
            sb.append(xor);
        }
        return sb.toString();
    }
}