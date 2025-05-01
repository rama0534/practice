
package org.hackerrank.OneWeekPreparationKit.dayThree;

public class CaesarCipher {
    public static String caesarCipher(String s, int k) {
        StringBuilder encrypted = new StringBuilder();
        k = k % 26;
        for ( char c : s.toCharArray()) {
            if(Character.isLowerCase(c)) {
                encrypted.append((char) ( (c - 'a' + k) % 26 + 'a'));
            } else if(Character.isUpperCase(c)) {
                encrypted.append((char) ((c - 'A' + k) % 26 + 'A'));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }
}
