package cryptography;

import java.util.Scanner;

public class VigenereCipher {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        double length = Math.ceil(Math.random() * message.length());
        double[] key = new double[(int) length];
        for (int i = 0; i < length; i++) {
            key[i] = Math.ceil(Math.random() * 26);
        }

        VignereEncryption ve = new VignereEncryption(message, length, key);
        System.out.println(ve.encryption());
        System.out.println(ve.decryption());
    }
}

class VignereEncryption {
    private String message;
    private double length;
    private double[] key;

    VignereEncryption(String message, double length, double[] key) {
        this.message = message;
        this.length = length;
        this.key = key;
    }
    StringBuilder cipherText = new StringBuilder();
    public String encryption() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isUpperCase(c)) {
                char ch = (char) ((c - 'A' + key[i % (int) (length-1)] + 26) % 26 + 'A');
                sb.append(c);
            } else {
                char ch = (char) ((c - 'a' + key[i % (int) (length)] + 26) % 26 + 'a');
                sb.append(ch);
            }
        }
        cipherText = sb;
        return sb.toString();
    }

    public String decryption() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            if (Character.isUpperCase(c)) {
                char ch = (char) ((c - 'A' - key[i % (int) (length-1)] + 26) % 26 + 'A');
                sb.append(c);
            } else {
                char ch = (char) ((c - 'a' - key[i % (int) (length)] + 26) % 26 + 'a');
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}