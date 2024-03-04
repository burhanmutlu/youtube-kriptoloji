package com.burhanmutlu;

public class Main {
    public static void main(String[] args) {

        int a = 17, b = 20;
        String sifrelenecekMetin = "merhababenburhanmutlu";
        StringBuilder sifreliMetin = new StringBuilder();

        for (int i = 0; i < sifrelenecekMetin.length(); i++) {
            int x = (int) sifrelenecekMetin.charAt(i) -97;
            char c = (char) ((a*x + b) % 26 + 97);
            sifreliMetin.append(c);
        }

        System.out.println(sifreliMetin);

        for (int i = 0; i < sifreliMetin.length(); i++) {
            int x = -1, z=0;
            while (true) {
                x++;
                z = a*x + b;
                int y = (int) sifreliMetin.charAt(i) - 97;
                if(z%26==y) {
                    System.out.print((char)(x+97));
                    break;
                }
            }
        }












    }
}