package cryptography;

public class ShiftCipher {
    public static void main(String[] args) {
        double k = Math.random() * 26;
        k = Math.ceil(k);
        Encryption e = new Encryption("zbc", k);
        System.out.println(e.encrypt());
        System.out.println(e.decrypt());
    }
}

class Encryption {
    private String s;
    private double k;
    Encryption(String s, double k) {
        this.s = s;
        this.k = k;
    }
    StringBuilder cipherText = new StringBuilder();
    public String encrypt() {
        StringBuilder sb =  new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                char ch = (char) ((c - 'A' + k) % 26 + 'A');
                sb.append(ch);
            } else {
                char ch = (char) ((c - 'a' + k) % 26 + 'a');
                sb.append(ch);
            }
        }
        cipherText = sb;
        return sb.toString();
    }

    public String decrypt() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            if (Character.isUpperCase(c)) {
                char ch = (char) ((c - 'A' - k + 26) % 26 + 'A');
                sb.append(ch);
            } else {
                char ch = (char) ((c - 'a' - k + 26) % 26 + 'a');
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}