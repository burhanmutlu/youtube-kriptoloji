package com.burhanmutlu;

public class Main {
    public static void main(String[] args) {

        String metin = "xyz";
        StringBuilder yeniMetin = new StringBuilder();

        int key = 8;

        for (int i = 0; i < metin.length(); i++) {
            int temp = (int) metin.charAt(i);
            temp = temp + key;
            if(temp > 122) {
                temp = temp - 26;
            }

            yeniMetin.append((char)temp);
        }

        System.out.println(yeniMetin);

        // decryption

        StringBuilder cozulmusMetin = new StringBuilder();

        for (int i = 0; i < yeniMetin.length(); i++) {
            int temp = (int) yeniMetin.charAt(i);
            temp = temp - key;
            if(temp < 97) {
                temp = temp + 26;
            }
            cozulmusMetin.append((char)temp);

        }

        System.out.println(cozulmusMetin);




    }
}