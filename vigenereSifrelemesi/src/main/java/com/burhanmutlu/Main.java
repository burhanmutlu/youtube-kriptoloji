package com.burhanmutlu;

public class Main {
    public static void main(String[] args) {


        String sifrelenecekMetin = "burhanmutlu";
        String key = "key";

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < sifrelenecekMetin.length(); i++) {
            int t = (int) sifrelenecekMetin.charAt(i) - 97;
            int index = i % key.length();
            int sifreli = (t + (key.charAt(index)-97)) % 26;
            s.append((char)(sifreli+97));
        }
        System.out.println(s);

        StringBuilder c = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int t = (int) s.charAt(i) - 97;
            int index = i % key.length();
            int cozulu = (t - (key.charAt(index)-97));
            while (cozulu<0) cozulu += 26;
            c.append((char)(cozulu+97));
        }

        System.out.println(c);


    }
}